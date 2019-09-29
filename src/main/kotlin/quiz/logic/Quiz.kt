package quiz.logic

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Connection


fun main() {
    val question = "Kotlinを開発した会社は？"
    val answer = "JetBrains"
    findAllArticles()
}

fun findAllArticles() {
    var conn: Connection? = null
    var statement: Statement? = null
    var resultSet: ResultSet? = null

    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/study_support?useSSL=false", "root", "")
        statement = conn?.createStatement()
//        resultSet = statement?.executeQuery("INSERT INTO qa_set VALUES (1,'Kotlinを開発した会社は','JetBrains','')")
        resultSet = statement?.executeQuery("select * from qa_set")
        while(resultSet?.next() ?: false) {
            println(resultSet?.getString("question"))
        }
    } finally {
        resultSet?.close()
        statement?.close()
        conn?.close()
    }
}

