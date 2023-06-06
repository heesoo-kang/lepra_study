<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap JSP board</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1>Bootstrap JSP board</h1>

        <!-- 글쓰기 폼 -->
        <form method="post" action="write.jsp">
            <div class="form-group">
                <label for="title">title</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="title" required>
            </div>
            <div class="form-group">
                <label for="content">content</label>
                <textarea class="form-control" id="content" name="content" rows="5" placeholder="content" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">write</button>
        </form>

        <hr>

        <!-- 게시물 목록 -->
        <table class="table">
            <thead>
                <tr>
                    <th>Number</th>
                    <th>TITLE</th>
                    <th>Writter</th>
                    <th>date</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td><a href="detail.jsp?id=1">first </a></td>
                    <td>writter1</td>
                    <td>2023-06-02</td>
                </tr>
                <!-- 추가적인 게시물들을 이곳에 반복적으로 표시 -->
            </tbody>
        </table>
    </div>
</body>
</html>
