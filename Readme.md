# Thrift to REST Migration with E2E Test

This project demonstrates migrating a simple Thrift-based service to a Spring Boot REST API, along with equivalent end-to-end (E2E) test coverage in Java.

--------
## 🚀 Step-by-Step Setup

### 1. 🛠 Generate Thrift Code

Install the Thrift compiler (if not already):

### Mac
```bash
    brew install thrift
```

### 2. Generate Java  code from calculator.thrift:
```bash
    cd src/main/java/org/demo/trifttorest
    
    thrift --gen java calculator.thrift
```

### 3. Run Thrift and Rest Servers

- #### Thrift
  - Run ```ThriftServer.java``` file.
  - Thrift Server will run on 9090

- #### Rest
    - Run ```TriftToRestApplication.java``` file.
    - Thrift Server will run on 8080

``Note``: Application is using Java 21


## 📘 Thrift vs REST: Key Differences

| Feature                        | **Apache Thrift**                                      | **REST (Representational State Transfer)**                   |
| ------------------------------ | ------------------------------------------------------ | ------------------------------------------------------------ |
| **Protocol Type**              | Binary protocol, **RPC-based**                         | **HTTP-based**, resource-oriented                            |
| **Communication Style**        | Function/method calls (`add(1, 2)`)                    | Resource actions via URLs (`POST /users`, `GET /products`)   |
| **Transport Layer**            | TCP (can use HTTP, WebSockets, etc.)                   | Strictly HTTP                                                |
| **Serialization Format**       | Binary, Compact, JSON, etc. (very efficient)           | JSON or XML (human-readable but larger)                      |
| **Speed & Performance**        | ⚡ Faster (due to binary format and minimal overhead)   | 🐢 Slower than Thrift (due to HTTP and verbose formats)      |
| **Language Support**           | Supports many: Java, Go, Python, C++, Rust, etc.       | Natively works with HTTP libraries in most languages         |
| **IDL (Interface Definition)** | Uses `.thrift` files to define services and data types | No IDL (you use OpenAPI/Swagger optionally)                  |
| **Tooling**                    | Thrift compiler generates clients and servers          | Requires manual endpoint and client setup                    |
| **Versioning & Contracts**     | Strongly typed contracts via IDL                       | Weakly typed; contract management is external                |
| **Use Case Fit**               | Microservices with high performance, internal APIs     | Public APIs, web/mobile integration, loosely coupled systems |
| **Streaming Support**          | Limited (can be implemented)                           | Supported via HTTP/2, WebSockets                             |
| **Debuggability**              | Harder due to binary format                            | Easy (can test via Postman, curl)                            |

## 🧪 Example Comparison
### 🔧 Thrift (RPC style)

#### thrift
```
    service CalculatorService {
        i32 add(1: i32 num1, 2: i32 num2)
    }
```
Usage (Java-like pseudocode):
```java
CalculatorService.Client client = new CalculatorService.Client(protocol);
int result = client.add(3, 4); // RPC call
```
### 🌐 REST (Resource style)

#### http
```
GET /api/calculator/add?num1=3&num2=4
```
#### Usage (curl):
```bash
  curl "http://localhost:8080/api/calculator/add?num1=3&num2=4"
```



