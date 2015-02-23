module.exports = function(grunt) {
	require('load-grunt-tasks')(grunt);

	grunt.initConfig({
		jshint: {
			all: ['inc/js/app.js']
		},
		uglify: {
			options: {
				mangle: false
			},
			jsmin: {
				files: {
					'html/js/min.js': ['lib/angular/angular.js','lib/angular-route/angular-route.js','lib/angular-sanitize/angular-sanitize.js','lib/angular-animate/angular-animate.js','lib/angular-bootstrap/ui-bootstrap.js','lib/angular-bootstrap/ui-bootstrap-tpls.js','inc/js/app.js']
				}
			}
		},
		cssmin: {
			combine: {
				files: {
					'html/css/min.css': ['lib/bootstrap/dist/css/bootstrap.css','lib/bootstrap/dist/css/bootstrap-theme.css','inc/css/style.css']
				}
			}
		},
		processhtml: {
			dist: {
				files: {
					'html/index.html': ['inc/index.html'],
					'html/tpls/search.html': ['inc/tpls/search.html'],
					'html/tpls/file.html': ['inc/tpls/file.html']
				}
			}
		},
		htmlmin: {
			dist: {
				options: {
					removeComments: true,
					collapseWhitespace: true
				},
				files: {
					'html/index.html': 'html/index.html',
					'html/tpls/search.html': 'html/tpls/search.html',
					'html/tpls/file.html': 'html/tpls/file.html'
				}
			}
		},
		copy: {
			main: {
				files: [
					{expand: true, flatten: true, src: ['lib/bootstrap/dist/fonts/*'], dest: 'html/fonts/', filter: 'isFile'},
					{expand: false, flatten: true, src: ['qt/windows/medbase48x48.ico'], dest: 'inc/favicon.ico', filter: 'isFile'},
					{expand: false, flatten: true, src: ['qt/windows/medbase48x48.ico'], dest: 'html/favicon.ico', filter: 'isFile'},
					{expand: false, flatten: true, src: ['base/medbase.db'], dest: 'html/medbase.db', filter: 'isFile'}
				]
			}
		}
	});

	grunt.registerTask('default', ['jshint','uglify','cssmin','processhtml','htmlmin','copy']);
}