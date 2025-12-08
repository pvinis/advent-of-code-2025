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

	function union(x: number, y: number) {
		const px = find(x)
		const py = find(y)
		if (px === py) return
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
	}

	const numConnections = 1000
	for (let k = 0; k < numConnections; k++) {
		union(pairs[k].i, pairs[k].j)
	}

	const componentSizes = new Map<number, number>()
	for (let i = 0; i < points.length; i++) {
		const root = find(i)
		componentSizes.set(root, (componentSizes.get(root) || 0) + 1)
	}

	const sizes = [...componentSizes.values()].sort((a, b) => b - a)
	const answer = sizes[0] * sizes[1] * sizes[2]

	console.log("answer:")
	console.log(answer)
}
