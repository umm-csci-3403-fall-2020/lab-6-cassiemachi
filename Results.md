# Experimental results


**We tried several variations for our EchoServer:**
1. _unbounded thread pool, with automatic thread reclamation_
  * For us, this yielded the quickest result times, we tried doing this with up to 
  80 clients, incrementing 10 clients at a time for our tests.  The time scaled up 
  pretty slowly, and stayed at a nearly consistent 20 seconds once the number of clients 
  was higher
2. _Fixed size thread pool (sizes 1-15)_
  * On our laptop, this turned out to yield slower results than the previous trials we did.
  Increasing the pool sized yeiled a quicker runtime, but this was only truly significant once
  the number of clients was on the larger side. 
