var gulp = require('gulp'),
	gutil = require('gulp-util'),
	uglify = require('gulp-uglify'),
 	concat = require('gulp-concat'),
	connect = require('gulp-connect');

gulp.task('js', function() {
	gulp.src('./js/**/*.js')
		.pipe(uglify())
		.pipe(concat('all.js'))
		.pipe(gulp.dest('./js'));
});

gulp.task('watch', function() {
	gulp.watch('./js/**/*.js', ['js']);
});

gulp.task('webserver', function() {
	connect.server({
		livereload: true
	});
});

gulp.task('default', ['webserver', 'watch']);

