console.log("connected");

/*
  MOBILE MENU LOADER.
 */
document.addEventListener("DOMContentLoaded", function() {
    const toggleButton = document.querySelector("[data-collapse-toggle]");
    const navMenu = document.getElementById("navbar-cta");

    toggleButton.addEventListener("click", function() {
        navMenu.classList.toggle("hidden");
    });
});


/*
 DARK MODE CODE.
 */
let currentTheme = getTheme();

setupTheme();

function setupTheme() {

    document.querySelector("html").classList.add(currentTheme);

    const button = document.querySelector("#themeChange");
    button.addEventListener("click", (e) => {
        let oldTheme = currentTheme;
        const icon = '<i class="fa-solid fa-circle-half-stroke"></i>';
        if (currentTheme === "light") {
            currentTheme = "dark";
            button.innerHTML = icon + " Light";
        } else {
            currentTheme = "light";
            button.innerHTML = icon + " Dark";
        }
        setTheme(currentTheme);
        if (oldTheme) {
            document.querySelector("html").classList.remove(oldTheme);
        }
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