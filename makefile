setup:
	docker pull ghcr.io/01-edu/test-java:latest

# Target: make test pr=ExerciseName
test:
	@if [ -z "$(pr)" ]; then \
		echo "Please specify the exercise name: make test pr=ExerciseName"; \
		exit 1; \
	fi
	@rm -rf student
	@mkdir -p student/$(pr)
	@cp -r $(pr)/*.java student/$(pr)/
	@docker run --rm -e EXERCISE=$(pr) -v $(PWD)/student:/app/student ghcr.io/01-edu/test-java:latest
	@rm -rf student
