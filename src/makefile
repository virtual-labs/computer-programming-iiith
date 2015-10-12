JAVAC=javac
sources = $(EXP_1sep2010 *.java)
classes = $(sources: .java=.class)

all: $(classes)

%.class : %.java
	$(JAVAC) $<
build-dir=../build
theme=green-icon

all: ${theme}

green-icon:
	mkdir ${build-dir};rsync -avC --progress lab/* themes/${theme}/* ${build-dir}
clean:
	rm -rf ${build-dir}
