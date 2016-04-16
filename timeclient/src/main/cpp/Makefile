CXX=g++
CC=gcc

THRIFT_SERVER=0.0.1

uname_S := $(shell sh -c 'uname -s 2>/dev/null || echo not')

# Cross compiling variables
XC_HOST=
XC_TGT=
XC_BUILD=

GENCPPPATH := ../../../../thrift-source/

ifeq ($(compile_mode),prod)
OPTIMIZATION?=-O2
OPT=$(OPTIMIZATION)
CXXFLAGS=-Wall -std=c++11 ${OPT} -fPIC -D__STDC_FORMAT_MACROS -I{GENCPPPATH}/ -I/usr/local/include/thrift
CCFLAGS=-Wall -std=gnu99 ${OPT} -fPIC -pedantic -D__STDC_FORMAT_MACROS
else
CXXFLAGS=-Wall -std=c++11 -g -fPIC -I../../../../thrift-source/ -I/usr/local/include/thrift
CCFLAGS=-Wall -std=gnu99 -fPIC -pedantic -g -D__STDC_FORMAT_MACROS
LDFLAGS=-g
endif

GENOBJ := thrift-client.o ${GENCPPPATH}/gen-cpp/TmServer.cpp

#TmServerHandlerImpl.o thrift-server.o

all: thriftclient


thriftclient: ${GENOBJ}
	${CXX} -o thrift-client ${GENOBJ} ${LIBS}

LIBS= -lpthread -lthrift -lboost_serialization -lboost_system

%.o : %.cpp
	${CXX} -c ${CXXFLAGS} ${INCS} $< -o $@

%.o : %.c
	${CC} -c ${CCFLAGS} ${INCS} $< -o $@


clobber : clean

clean :
	rm -rf thrift-client
	rm *.o
