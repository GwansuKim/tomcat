/**
 *
 */

// bookList배열을 활용해서 처리하도록 하세요.
let bookList = [
  {
    bookCode: "P0206001",
    bookTitle: "이것이자바다",
    bookAuthor: "홍성문",
    bookPress: "신흥출판사",
    bookPrice: "20000",
  },
  {
    bookCode: "P0206002",
    bookTitle: "이것이자바스크립트다",
    bookAuthor: "홍영웅",
    bookPress: "우리출판사",
    bookPrice: "25000",
  },
];

showList();

function showList() {
  list.innerHTML = "";
  for (let i = 0; i < bookList.length; i++) {
    let tr = document.createElement("tr");
    let td = document.createElement("td");
    let chkBox = document.createElement("input");
    chkBox.addEventListener("change", oneSelect);
    chkBox.setAttribute("type", "checkbox");
    td.append(chkBox);
    tr.append(td);

    for (let prop in bookList[i]) {
      td = document.createElement("td");
      td.innerText = bookList[i][prop];
      tr.append(td);
    }

    let delBtn = document.createElement("button");
    delBtn.setAttribute("class", "delBtn");
    delBtn.addEventListener("click", deleteOneSelect);
    delBtn.innerText = "삭제";
    tr.append(delBtn);

    list.append(tr);
  }
}

function addBook() {
  let newBook = {
    bookCode: document.querySelector("#bookCode").value,
    bookName: document.querySelector("#bookName").value,
    author: document.querySelector("#author").value,
    press: document.querySelector("#press").value,
    price: document.querySelector("#price").value,
  };
  bookList.push(newBook);
  showList();

  document.querySelector("#bookCode").value = "";
  document.querySelector("#bookName").value = "";
  document.querySelector("#author").value = "";
  document.querySelector("#press").value = "";
  document.querySelector("#price").value = "";
}

function deleteOneSelect() {
  let delCode = this.closest("tr").children[1];
  let index = bookList.findIndex((e) => e.bookCode == delCode.innerText);
  bookList.splice(index, 1);
  showList();
}

function allSelect() {
  let chkBoxList = document.querySelectorAll("tbody input");
  for (let i = 0; i < chkBoxList.length; i++) {
    if (document.querySelector("#allSelectChk").checked == true) {
      document.querySelectorAll("tbody input")[i].checked = true;
    } else if (document.querySelector("#allSelectChk").checked == false) {
      document.querySelectorAll("tbody input")[i].checked = false;
    }
  }
}

function deleteCheckedFnc() {
  let tr = document.querySelectorAll('tbody input[type="checkbox"]:checked');
  if (tr.length == 0) {
    alert("선택된 사원이 없습니다");
    return;
  }
  for (let i = 0; i < tr.length; i++) {
    let delCode = tr[i].closest("tr").children[1].innerText;
    let index = bookList.findIndex((e) => e.bookCode == delCode);
    bookList.splice(index, 1);
  }
  showList();
}

function oneSelect() {
  let firChkBox = document.querySelector('thead input[type="checkbox"]');

  let othChkBox = document.querySelectorAll('tbody input[type="checkbox"]');

  for (let i = 0; i < othChkBox.length; i++) {
    if (othChkBox[i].checked != true) {
      firChkBox.checked = false;
      return;
    }
  }
  firChkBox.checked = true;
}
