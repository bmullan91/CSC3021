
#Question

 - Where the rendez-vous pattern synchronises 2 processes, the barrier synchronisation problem is one where  any number of n processes need to synchronise.

__Every thread should execute the following code:__

  1. rendez-vous
  2. critical point

__Note:__

- The synchronisation requirement is that no thread should execute critical point until all threads have executed rendez-vous.
- You can assume that there are n threads and that this value is stored in a variable, n, that is accessible from all threads.
- When the first n − 1 threads arrive they should block until the nth thread arrives, at which point all the threads may proceed.

*Source: Allen B. Downey. The Little Book of Semaphores.*