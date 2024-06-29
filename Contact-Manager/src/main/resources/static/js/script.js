console.log("connected");

let currentTheme = getTheme();

document.querySelector("#themeChange").innerHTML = "Rehan";
setupTheme();

function setupTheme() {

    document.querySelector("html").classList.add(currentTheme);

    const button = document.querySelector("#themeChange");
    button.addEventListener("click", (e) => {
        let oldTheme = currentTheme;
        if (currentTheme === "light") {
            currentTheme = "dark";
            button.innerHTML = "Light";
        } else {
            currentTheme = "light";
            button.innerHTML = "Light";
        }
        setTheme(currentTheme);
        document.querySelector("html").classList.remove(oldTheme);
        document.querySelector("html").classList.add(currentTheme);
    })

}

function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

function getTheme() {
    let theme = localStorage.getItem("theme");
    if (theme) {
        return theme;
    } else {
        return "light";
    }
}