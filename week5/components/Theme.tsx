// theme.ts

// 1. import `extendTheme` function
import { extendTheme, type ThemeConfig } from '@chakra-ui/react';

// 2. Add your color mode config
const config: ThemeConfig = {
  initialColorMode: 'dark',
  useSystemColorMode: false,
};

// 3. Extend the theme with custom settings
const theme = extendTheme({
  config,
  colors: {
    brand: {
      50: '#f5e6f7',
      100: '#e3c7e5',
      200: '#d0a8d4',
      300: '#bd88c2',
      400: '#aa69b1',
      500: '#904f97',
      600: '#703c77',
      700: '#502957',
      800: '#301637',
      900: '#100317',
    },
    accent: {
      50: '#e5f4fd',
      100: '#bfe3fa',
      200: '#99d2f7',
      300: '#73c1f4',
      400: '#4dafef',
      500: '#3396d6',
      600: '#276ea7',
      700: '#1a4678',
      800: '#0d1e49',
      900: '#00071c',
    },
  },
  fonts: {
    heading: "'Poppins', sans-serif",
    body: "'Roboto', sans-serif",
  },
  components: {
    Button: {
      baseStyle: {
        fontWeight: 'bold',
        textTransform: 'uppercase',
      },
      sizes: {
        lg: {
          h: '48px',
          fontSize: 'lg',
          px: '32px',
        },
        md: {
          h: '40px',
          fontSize: 'md',
          px: '24px',
        },
        sm: {
          h: '32px',
          fontSize: 'sm',
          px: '16px',
        },
      },
      variants: {
        solid: (props) => ({
          bg: props.colorMode === 'dark' ? 'brand.400' : 'accent.500',
          color: props.colorMode === 'dark' ? 'white' : 'black',
          _hover: {
            bg: props.colorMode === 'dark' ? 'brand.500' : 'accent.600',
          },
        }),
        outline: (props) => ({
          borderColor: props.colorMode === 'dark' ? 'brand.400' : 'accent.500',
          color: props.colorMode === 'dark' ? 'brand.400' : 'accent.500',
          _hover: {
            bg: props.colorMode === 'dark' ? 'brand.500' : 'accent.600',
            color: props.colorMode === 'dark' ? 'white' : 'black',
          },
        }),
      },
    },
  },
});

export default theme;
