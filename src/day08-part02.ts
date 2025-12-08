import { readLines } from "./utils/input"

main()

async function main() {
	const lines = await readLines(process.env.INPUT_FILE!)

	const points = lines
		.filter((l) => l.trim())
		.map((line) => {
			const [x, y, z] = line.split(",").map(Number)
			return { x, y, z }
		})

	const pairs: { i: number; j: number; dist: number }[] = []
	for (let i = 0; i < points.length; i++) {
		for (let j = i + 1; j < points.length; j++) {
			const dx = points[i].x - points[j].x
			const dy = points[i].y - points[j].y
			const dz = points[i].z - points[j].z
			const dist = Math.sqrt(dx * dx + dy * dy + dz * dz)
			pairs.push({ i, j, dist })
		}
	}

	pairs.sort((a, b) => a.dist - b.dist)

	const parent = new Map<number, number>()
	const rank = new Map<number, number>()

	function find(x: number): number {
		if (!parent.has(x)) {
			parent.set(x, x)
			rank.set(x, 0)
		}
		if (parent.get(x) !== x) {
			parent.set(x, find(parent.get(x)!))
		}
		return parent.get(x)!
	}

	function union(x: number, y: number): boolean {
		const px = find(x)
		const py = find(y)
		if (px === py) return false
		const rx = rank.get(px)!
		const ry = rank.get(py)!
		if (rx < ry) {
			parent.set(px, py)
		} else if (rx > ry) {
			parent.set(py, px)
		} else {
			parent.set(py, px)
			rank.set(px, rx + 1)
		}
		return true
	}

	let numComponents = points.length
	for (const pair of pairs) {
		if (union(pair.i, pair.j)) {
			numComponents--
			if (numComponents === 1) {
				const answer = points[pair.i].x * points[pair.j].x
				console.log("answer:")
				console.log(answer)
				return
			}
		}
	}
}
