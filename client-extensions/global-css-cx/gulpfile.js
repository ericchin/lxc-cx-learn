const gulp = require('gulp');
// Requires the gulp-sass plugin
const sass = require('gulp-sass')(require('node-sass'));

gulp.task('compile', function(){
    return gulp.src('src/**')
        .pipe(sass()) // Using gulp-sass
        .pipe(gulp.dest('build'))
});