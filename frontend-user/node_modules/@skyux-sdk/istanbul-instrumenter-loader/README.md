# @skyux-sdk/istanbul-instrumenter-loader

[![npm](https://img.shields.io/npm/v/@skyux-sdk/istanbul-instrumenter-loader.svg)](https://www.npmjs.com/package/@skyux-sdk/istanbul-instrumenter-loader)
[![status](https://travis-ci.org/blackbaud/skyux-sdk-istanbul-instrumenter-loader.svg?branch=master)](https://travis-ci.org/blackbaud/skyux-sdk-istanbul-instrumenter-loader)
[![coverage](https://codecov.io/gh/blackbaud/skyux-sdk-istanbul-instrumenter-loader/branch/master/graphs/badge.svg?branch=master)](https://codecov.io/gh/blackbaud/skyux-sdk-istanbul-instrumenter-loader/branch/master)

## Usage

**webpack.config.js**
```
{
  rules: [
    {
      enforce: 'post',
      test: /\.(js|ts)$/,
      use: [
        {
          loader: '@skyux-sdk/istanbul-instrumenter-loader',
          options: {
            esModules: true
          }
        }
      ],
      exclude: [
        /node_modules/
      ]
    }
  ]
}
```