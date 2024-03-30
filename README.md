# Rate limiter(s) poc

Simple poc to demo a variety of rate limiters.

Currently implemented:

- Simple rate limiter (using concurrent hashmap)
- Redis Rate Limiter (using Redis). Requires Redis server running.

### To-do and implement

- Client identifier builder
- Rules service, DB, cache, retriever


- Develop various algorithm examples using:
  - token bucket (wip)
  - leaking bucket
  - fixed window
  - sliding window