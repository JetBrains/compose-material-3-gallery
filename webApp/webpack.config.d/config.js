// https://youtrack.jetbrains.com/projects/KT/issues/KT-87647
// Please note that webpack now depends on minimizer-webpack-plugin instead of terser-webpack-plugin
// This plugin was renamed: https://www.npmjs.com/package/terser-webpack-plugin
let TerserPlugin;
try {
    TerserPlugin = require("terser-webpack-plugin");
} catch (e) {}

if (TerserPlugin) {
    config.optimization = config.optimization || {};
    config.optimization.minimize = true;
    config.optimization.minimizer = [
        new TerserPlugin({
            terserOptions: {
                mangle: true,    // Note: By default, mangle is set to true.
                compress: false, // Disable the transformations that reduce the code size.
                output: {
                    beautify: false,
                },
            },
        }),
    ];
}
