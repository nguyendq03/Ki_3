const form = document.getElementById("form");
const mainForm = document.querySelector(".total-amount");

form.onsubmit = (e) => {
  e.preventDefault();
  let htmls = "";
  const amount = e.target.elements[1].value * 150;
  htmls += `
    <div class="amount">
      Total amount:${amount}$
    </div>
  `;
  console.log(htmls);
  mainForm.innerHTML = htmls;
}
