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
<form class="row" action="/nhan-vien/add" method="post">
    <div class="col-md-4">
        <label class="form-label">Mã:</label>
        <input type="text" class="form-control" name="ma" value="${nhanVien.ma}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên:</label>
        <input type="text" class="form-control" name="ten" value="${nhanVien.ten}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên đệm</label>
        <input type="text" class="form-control" name="tenDem" value="${nhanVien.tenDem}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Họ</label>
        <input type="text" class="form-control" name="ho" value="${nhanVien.ho}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Giới tính</label>
        <input type="radio" name="gioiTinh" checked value="Nam" ${nhanVien.gioiTinh == "Nam" ? "Checked": ""}>Nam
        <input type="radio" name="gioiTinh" value="Nữ" ${nhanVien.gioiTinh == "Nữ" ? "Checked": ""}>Nữ
    </div>
    <div class="col-md-4">
        <label class="form-label">Ngày Sinh</label>
        <input type="text" class="form-control" name="ngaySinh" value="${nhanVien.ngaySinh}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Địa chỉ</label>
        <input type="text" class="form-control" name="diaChi" value="${nhanVien.diaChi}">
    </div>
    <div class="col-md-4">
        <label class="form-label">SĐT</label>
        <input type="text" class="form-control" name="sdt" value="${nhanVien.sdt}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Mật Khẩu</label>
        <input type="text" class="form-control" name="matKhau" value="${nhanVien.matKhau}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Cửa Hàng</label>
        <select name="cuaHang" class="form-select">
            <c:forEach items="${listCH}" var="ch">
                <option value="${ch.id}" ${nhanVien.cuaHang.ten == ch.ten ? "Selected":""}> ${ch.ten} </option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-4">
        <label class="form-label">Chức vụ</label>
        <select name="chucVu" class="form-select">
            <c:forEach items="${listCV}" var="cv">
                <option value="${cv.id}" ${nhanVien.chucVu.ten == cv.ten ? "Selected":""}> ${cv.ten} </option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-4">
        <label class="form-label">Trạng thái</label>
        <input type="radio" name="trangThai" checked value=0 ${nhanVien.trangThai == 0 ? "Checked": ""}>Hoạt
        động
        <input type="radio" name="trangThai" value=1 ${nhanVien.trangThai == 1 ? "Checked": ""}>Không
        hoạt động
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
        <th scope="col">Giới tính</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">SĐT</th>
        <th scope="col">Mật Khẩu</th>
        <th scope="col">Cửa Hàng</th>
        <th scope="col">Chức vụ</th>
        <th scope="col">Trạng thái</th>
        <th scope="col-3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNV.content}" var="nhanvien" varStatus="i">
        <tr>
            <th>${i.index + 1}</th>
            <th>${nhanvien.ma}</th>
            <td>${nhanvien.ho} ${nhanvien.tenDem} ${nhanvien.ten}</td>
            <td>${nhanvien.gioiTinh}</td>
            <td>${nhanvien.ngaySinh}</td>
            <td>${nhanvien.diaChi}</td>
            <td>${nhanvien.sdt}</td>
            <td>${nhanvien.matKhau}</td>
            <td>${nhanvien.cuaHang.ten}</td>
            <td>${nhanvien.chucVu.ten}</td>
            <td>
                <c:if test="${nhanvien.trangThai == 0}">Hoạt Động</c:if>
                <c:if test="${nhanvien.trangThai == 1}">Không Hoạt Động</c:if>
            </td>
            <td>
                <button><a style="text-decoration: none" href="/nhan-vien/detail?idDetail=${nhanvien.id}">Detail</a>
                </button>
                <button><a style="text-decoration: none" href="/nhan-vien/remove?idRemove=${nhanvien.id}">Remove</a>
                </button>
                <button><a style="text-decoration: none" href="/nhan-vien/view-update?idEdit=${nhanvien.id}">Edit</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <c:forEach begin="0" end="${listNV.totalPages -1}" varStatus="loop">
            <a class="page-link" href="/nhan-vien/hien-thi?page=${loop.begin + loop.count-1}">
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
