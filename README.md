# graphql-spring-boot

* Spring Boot 2.1.6.RELEASE
* Dozer 5.5.1
* mysql connector java 8.0.16

Spring Boot中使用GraphQL的Demo。对象到对象的映射框架使用了Dozer。使用JPA操作数据库，涉及到Author和Book两张表，application.yml中配置正确的数据库账号密码以及存在的数据库，表会自动生成。

### 访问http://localhost:8090/graphiql 进行操作
### 本项目用到接口

#### 查询接口
```
query {
  # 查询所有书籍
  findAllBooks {
    id
    bookTitle
    author {
      authorName
      authorAge
      authorSex
    }
  	publishedDate
    publishingHouseName
  },
  # 根据书籍id查询书籍
  getBookByBookId(bookId: 1) {
    bookTitle
  },
  # 根据作者id查询书籍
  findBooksByAuthorId(authorId: 1) {
    bookTitle
  },
  # 查询所有作者
  findAllAuthors {
    id
    authorName
    authorAge
    authorSex
  }
  # 根据作者id查询作者
  getAuthorByAuthorId(authorId: 1) {
    id
    authorName
    authorAge
    authorSex
  }
}
```

#### 添加和修改接口
```
mutation {
  # 添加作者
  saveAuthor(input: {
    authorName: "test"
    authorAge: 100
    authorSex: 1
  }) {
    id
    authorName
    authorAge
    authorSex
  }
  # 更新作者
  updateAuthor(input: {
    id: 2
    authorName: "test2"
    authorAge: 30
    authorSex: 2
  }) {
    id
    authorName
    authorAge
    authorSex
  }
  # 删除作者
  deleteAuthor(authorId: 8)
  # 添加书籍
  saveBook(input: {
    id: 3
    bookTitle: "ceshi"
    authorId: 10
    publishedDate: "2019年"
    publishingHouseName: "测试出版社"
  }) {
  	id
    bookTitle
    author {
      authorName
      authorAge
      authorSex
    }
  	publishedDate
    publishingHouseName
  },
  # 更新书籍
  updateBook(input: {
    id: 6
    bookTitle: "ceshi"
    authorId: 6
    publishedDate: "2019年"
    publishingHouseName: "测试出版社"
  }) {
  	id
    bookTitle
    author {
      authorName
      authorAge
      authorSex
    }
  	publishedDate
    publishingHouseName
  }
  # 删除书籍
  deleteBook(bookId: 9)
}
```
