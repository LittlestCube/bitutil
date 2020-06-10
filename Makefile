all: dev test

dev:
	cd littlecube/bitutil && $(MAKE)

test:
	javac Test.java
	java Test

clean:
	cd littlecube/bitutil && $(MAKE) clean
	rm *.class || continue