const defaultTheme = require('tailwindcss/defaultTheme');
const plugin = require('tailwindcss/plugin');

module.exports = {
  prefix: '',
  mode: 'jit',
  content: ['./src/**/*.{html,ts,css,scss,sass,less,style}'],
  darkMode: 'class',
  theme: {
    extend: {
      fontFamily: {
        sans: [
          'system-ui', 
          '-apple-system', 
          'BlinkMacSystemFont', 
          '"Segoe UI"', 
          'Roboto', ...defaultTheme.fontFamily.sans]
      },
      backgroundImage: {
        waves: "url('/assets/images/background.svg')"
      },
      colors: {
        'transparent-gray-50': '#cdcdcd52',
        'transparent-gray-100': '#cdcdcd99',
        'green-light': '#e8f5e9',
        'green-strong': '#2e7d32',
        'app-text': '#1f2937',
        'app-muted': '#6b7280',
        'app-border': '#e5e7eb',
        '$shadow-dropdown': '0 30px 60px rgba(0, 0, 0, 0.08)',
      }
    }
  },
  corePlugins: {
    preflight: true
  },
  variants: {
    extend: {}
  },
  plugins: [
    require('@tailwindcss/forms'),
    require('@tailwindcss/typography'),
    require('@tailwindcss/aspect-ratio'),
    plugin(function ({ addUtilities }) {
      addUtilities({
        '.border-sketch-1': {
          'border-radius': '50px 15px 225px 15px/15px 225px 15px 20px'
        },
        '.border-sketch-2': {
          'border-radius': '255px 15px 225px 15px/15px 225px 15px 255px'
        }
      });
    })
  ]
};
