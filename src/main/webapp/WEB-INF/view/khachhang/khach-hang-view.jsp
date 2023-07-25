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
<form class="row" action="/khach-hang/add" method="post">
    <div class="col-md-4">
        <label class="form-label">Mã:</label>
        <input type="text" class="form-control" name="ma" value="${khachHang.ma}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên:</label>
        <input type="text" class="form-control" name="ten" value="${khachHang.ten}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên đệm</label>
        <input type="text" class="form-control" name="tenDem" value="${khachHang.tenDem}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Họ</label>
        <input type="text" class="form-control" name="ho" value="${khachHang.ho}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Ngày Sinh</label>
        <input type="text" class="form-control" name="ngaySinh" value="${khachHang.ngaySinh}">
    </div>
    <div class="col-md-4">
        <label class="form-label">SĐT</label>
        <input type="text" class="form-control" name="sdt" value="${khachHang.sdt}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Địa chỉ</label>
        <input type="text" class="form-control" name="diaChi" value="${khachHang.diaChi}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Thành Phố</label>
        <input type="text" class="form-control" name="thanhPho" value="${khachHang.thanhPho}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Quốc Gia</label>
        <input type="text" class="form-control" name="quocGia" value="${khachHang.quocGia}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Mật Khẩu</label>
        <input type="text" class="form-control" name="matKhau" value="${khachHang.matKhau}">
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
        <th scope="col">Mã</th>
        <th scope="col">Họ Tên</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">SĐT</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Thành Phố</th>
        <th scope="col">Quốc Gia</th>
        <th scope="col">Mật Khẩu</th>
        <th scope="col-3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKH.content}" var="khachhang" varStatus="i">
        <tr>
            <th>${i.index+1}</th>
            <th>${khachhang.ma}</th>
            <td>${khachhang.ho} ${khachhang.tenDem} ${khachhang.ten}</td>
            <td>${khachhang.ngaySinh}</td>
            <td>${khachhang.sdt}</td>
            <td>${khachhang.diaChi}</td>
            <td>${khachhang.thanhPho}</td>
            <td>${khachhang.quocGia}</td>
            <td>${khachhang.matKhau}</td>
            <td>
                <button><a style="text-decoration: none" href="/khach-hang/detail?idDetail=${khachhang.id}">Detail</a>
                </button>
                <button><a style="text-decoration: none" href="/khach-hang/remove?idRemove=${khachhang.id}">Remove</a>
                </button>
                <button><a style="text-decoration: none" href="/khach-hang/view-update?idEdit=${khachhang.id}">Edit</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <c:forEach begin="0" end="${listKH.totalPages -1}" varStatus="loop">
            <a class="page-link" href="/khach-hang/hien-thi?page=${loop.begin + loop.count-1}">
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
