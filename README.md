## Introduction
This is an API implemented in java using XML-RPC protocol.This protocol is implemented as a client
which requests for resources on server.

The Opensubtitle documentation creating API can be found [here](https://trac.opensubtitles.org/projects/opensubtitles/wiki/XMLRPC)

Download [dependency jar](www.google.com)

## Implementation
XML-RPC is the simplest XML-based protocol for exchanging information between computers across a network.RPC stands for Remote Procedure Call. As its name indicates, it is a mechanism to call a procedure or a function available on a remote computer. RPC is a much older technology than the Web. Effectively, RPC gives developers a mechanism for defining interfaces that can be called over a network. These interfaces can be as simple as a single function call or as complex as a large API.

### Things you can do using XML-RPC

* XML-RPC is among the simplest and most foolproof web service approaches that makes it easy for computers to call procedures on other computers.

* XML-RPC permits programs to make function or procedure calls across a network.

* XML-RPC uses the HTTP protocol to pass information from a client computer to a server computer.

* XML-RPC uses a small XML vocabulary to describe the nature of requests and responses.

* XML-RPC client specifies a procedure name and parameters in the XML request, and the server returns either a fault or a response in the XML response.

* XML-RPC parameters are a simple list of types and content - structs and arrays are the most complex types available.

* XML-RPC has no notion of objects and no mechanism for including information that uses other XML vocabulary.

* With XML-RPC and web services, however, the Web becomes a collection of procedural connections where computers exchange information along tightly bound paths.

### Why most of services provides API using XML-RPC?

If you need to integrate multiple computing environments, but don't need to share complex data structures directly, you will find that XML-RPC lets you establish communications quickly and easily.Even if you work within a single environment, you may find that the RPC approach makes it easy to connect programs that have different data models or processing expectations and that it can provide easy access to reusable logic.

## How to use?

First create instance of OpenSubtitle class
```
    OpenSubtitle openSubtitle=new OpenSubtitle();
    openSubtitle.login();
    openSubtitle.ServerInfo();
    
    
    //Control logic goes here
    
    
    
    openSubtitle.logOut();
```

Different methods are defined in OpenSubtitle class for accessing subtitles based on Moviename or Tv series name.

