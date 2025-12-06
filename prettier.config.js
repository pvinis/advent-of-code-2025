export default {
	useTabs: true,
	semi: false,
	singleQuote: false,
	printWidth: 100,

	overrides: [
		{
			files: "*.json",
			options: {
				useTabs: false,
				tabWidth: 2,
			},
		},
	],
}
