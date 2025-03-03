import eslint from 'eslint';
import prettier from 'eslint-plugin-prettier';
import importPlugin from 'eslint-plugin-import';
import jsxA11y from 'eslint-plugin-jsx-a11y';
import typescriptEslint from '@typescript-eslint/eslint-plugin';

export default typescriptEslint.config(
  {
    ignores: ['build'], // Now ignoring 'build' directory instead of 'dist'
  },
  {
    extends: [
      'eslint:recommended',
      'plugin:prettier/recommended', // Integrating Prettier for code formatting
      'plugin:jsx-a11y/recommended', // Accessibility plugin for JSX
      ...typescriptEslint.configs.recommended, // TypeScript ESLint recommended configs
    ],
    files: ['**/*.{ts,tsx}'], // Targeting TypeScript files
    languageOptions: {
      ecmaVersion: 2021, // Using a more recent ECMAScript version
      globals: { ...globals.browser }, // Defining global variables for the browser environment
    },
    plugins: {
      prettier, // Including Prettier plugin
      'import': importPlugin, // Adding import plugin for import/export syntax
      'jsx-a11y': jsxA11y, // Including accessibility plugin for JSX
    },
    rules: {
      ...prettier.configs.recommended.rules, // Prettier recommended rules
      ...jsxA11y.configs.recommended.rules, // Accessibility recommended rules
      'import/order': ['warn', { 'newlines-between': 'always' }], // Enforcing newline between imports
      '@typescript-eslint/no-unused-vars': ['error', { 'argsIgnorePattern': '^_' }], // Error for unused variables, ignoring those starting with _
    },
  }
);
