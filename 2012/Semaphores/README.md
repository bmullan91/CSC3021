#Question

__Consider the following scenario:__

A number of client processes share common access to a single printer via a shared data buffer.

The printer is managed by a process that repeatedly (forever) reads and prints pages from the data buffer in the order in which they were added.

The client processes repeatedly (forever) write documents of various sizes to the buffer, one page at a time, from page 1 up to the size of the document.

The client documents appear on the printer in order, without documents pages mixed up.

Provide abstract behaviours for both the client and printer processes, which make use of semaphores and simple variables to manage usage of the data buffer.

__You may assume that:__

- N represents the number of client processes (N>=2).
- M represents the size of the data buffer (M>0) which (for simplicity) stores each document page as a positive integer (i.e integers 4,3,2,1 in the data buffer represents the sequence of page numbers of a particular document being printed by a given client)
- Method call: i=generateDocument() returns (in ‘i') the number of pages in one document to be printed by a client process.
- Method call: printPage(p) prints a page p (represented by an integer).
