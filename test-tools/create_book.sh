curl -i -w '\n' \
-d '{"id":null, "name":"Build Restful APIs using Kotlin and SpringBoot", "category": "Development", "author": "RvdMolen", "isbn": "1234-1234"}' \
-H "Content-Type: application/json" \
-X POST http://localhost:8080/books