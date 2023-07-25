<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form class="row" action="/mau-sac/add" method="post">
    <div class="col-md-4">
        <label class="form-label">Mã:</label>
        <input type="text" class="form-control" name="ma" value="${mauSac.ma}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên:</label>
        <input type="text" class="form-control" name="ten" value="${mauSac.ten}">
    </div>
    <div class="col-12" style="margin-top: 10px">
        <button class="btn btn-primary" type="submit">Add</button>
        <div style="color: red">${error}</div>
    </div>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">ID</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col-3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listMS.content}" var="mausac" varStatus="i">
        <tr>
            <th>${i.index+1}</th>
            <th>${mausac.id}</th>
            <th>${mausac.ma}</th>
            <td>${mausac.ten}</td>
            <td>
                <button><a style="text-decoration: none" href="/mau-sac/detail?idDetail=${mausac.id}">Detail</a>
                </button>
                <button><a style="text-decoration: none" href="/mau-sac/remove?idRemove=${mausac.id}">Remove</a>
                </button>
                <button><a style="text-decoration: none" href="/mau-sac/view-update?idEdit=${mausac.id}">Edit</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <c:forEach begin="0" end="${listMS.totalPages -1}" varStatus="loop">
            <a class="page-link" href="/mau-sac/hien-thi?page=${loop.begin + loop.count-1}">
                    ${loop.begin + loop.count}
            </a></li>
        </c:forEach>
    </ul>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
