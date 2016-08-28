# queueman-being

A [re-frame](https://github.com/Day8/re-frame) application.

Queueman Being is a One-Button Game. 

You play as a Queueman Being.

In the Queue, a move will appear, say `<-`

Press `q` once to queue that move into your move-queue.

`<-`

Let the move take control, experience the move, complete the move.

In the Queue, a move will appear, say `->`

Press `q` in rapid succession to queue that move into your move-queue up to five times.

`-> -> -> -> ->`

Let the move take control...you get the idea.

Zen Queuedhism 
> You cannot control what move appears to you, only how many of it you queue.

## Development Mode

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```
