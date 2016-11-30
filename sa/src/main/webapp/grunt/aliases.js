module.exports = {
	"build:app":["build:angular","clean:app", "copy:app","clean:angular"],
	"build:angular": ["recess:less", "clean:angular", "copy:angular", "recess:angular", "concat:angular", "uglify:angular"],
	"build:html": ["clean:html", "copy:html", "recess:html", "swig:html", "concat:html", "uglify:html"],
	"build:landing":["copy:landing", "swig:landing"],
	
	"release":["bower-install-simple", "build:dev", "bump-commit"],
	"release-patch":["bump-only:patch", "release"],
	"release-minor":["bump-only:minor", "release"],
	"release-major":["bump-only:major", "release"],
	"prerelease":["bump-only:prerelease", "release"]
}