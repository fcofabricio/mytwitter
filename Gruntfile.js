module.exports = function(grunt) {
	grunt.initConfig({
		pkg: grunt.file.readJSON('package.json'),

		clean: {
	      resoureces: [
	        'src/main/webapp/resources'
	      ]
	    },

		less: {                              
			dist: {                            
        files: {
          'src/main/webapp/resources/application.css': 'src/main/assets/stylesheets/application.less'
        }
			}
		},

		cssmin: {
			options: {
		    banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n'
		  },
			dist: {
				expand: true,
				cwd: 'src/main/webapp/resources',
				src: ['*.css'],
				dest: 'src/main/webapp/resources',
				ext: '.css'
			}
		},

		concat: {
			options: {
			    separator: ';'
			},
			dist: {
			    src: [
			          'src/main/assets/bower_components/jquery/dist/jquery.js',
			          'src/main/assets/bower_components/bootstrap-sass/dist/js/bootstrap.js'
			    ],
			    dest: 'src/main/webapp/resources/application.js'
			}
		},

		uglify: {
		  options: {
		    banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n'
		  },
		  dist: {
		    files: {
		      'src/main/webapp/resources/application.js': ['src/main/webapp/resources/application.js']
		    }
		  }
		},

		qunit: {
			files: ['src/main/assets/scripts/test/*.js']
		},

		jshint : {
			files : [ 'gruntfile.js', 'src/main/assets/scripts/*.js', 'src/main/assets/scripts/test/*.js' ],
			options : {
				globals : {
					jQuery : true,
					console : true,
					module : true
				}
			}
		}
	});

	grunt.loadNpmTasks('grunt-contrib-clean');
	grunt.loadNpmTasks('grunt-contrib-less');
	grunt.loadNpmTasks('grunt-contrib-cssmin');
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-uglify');

	grunt.loadNpmTasks('grunt-contrib-jshint');
	grunt.loadNpmTasks('grunt-contrib-qunit');

	grunt.registerTask('test', ['jshint', 'qunit']);
	grunt.registerTask('default', ['clean', 'less', 'concat']);
	grunt.registerTask('dist', ['clean', 'less', 'cssmin', 'concat', 'uglify']);
}