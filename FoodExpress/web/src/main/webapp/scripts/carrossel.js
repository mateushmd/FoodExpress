document.addEventListener("click", e => {
    let handle
    if (e.target.matches(".handle")) {
        handle = e.target
    } else {
        handle = e.target.closest(".handle")
    }
    if (handle != null) onHandleClick(handle)
})

/*
const throttleProgressBar = throttle(() => {
    document.querySelectorAll(".progress-bar").forEach(calculateProgressBar)
}, 250)
window.addEventListener("resize", throttleProgressBar)

document.querySelectorAll(".progress-bar").forEach(calculateProgressBar)

function calculateProgressBar(progressBar) {
    progressBar.innerHTML = ""
    const slider = progressBar.closest(".row").querySelector(".slider")
    const itemCount = slider.children.length
    const itemsPerScreen = parseInt(
        getComputedStyle(slider).getPropertyValue("--items-per-screen")
    )
    let sliderIndex = parseInt(
        getComputedStyle(slider).getPropertyValue("--slider-index")
    )
    const progressBarItemCount = Math.ceil(itemCount / itemsPerScreen)

    if (sliderIndex >= progressBarItemCount) {
        slider.style.setProperty("--slider-index", progressBarItemCount - 1)
        sliderIndex = progressBarItemCount - 1
    }

    for (let i = 0; i < progressBarItemCount; i++) {
        const barItem = document.createElement("div")
        barItem.classList.add("progress-item")
        if (i === sliderIndex) {
            barItem.classList.add("active")
        }
        progressBar.append(barItem)
    }
}
*/

function onHandleClick(handle) {
    const slider = handle.closest(".container").querySelector(".slider")
    const itemCount = slider.childElementCount; 
    const sliderIndex = parseInt(
        getComputedStyle(slider).getPropertyValue("--slider-index")
    )
    const itemsPerScreen = parseInt(
        getComputedStyle(slider).getPropertyValue("--items-per-screen")
    )
    const sets = Math.ceil(itemCount / itemsPerScreen)
    if (handle.classList.contains("left-handle")) {
        if (sliderIndex - 1 < 0) {
            slider.style.setProperty("--slider-index", sets - 1)
        } else {
            slider.style.setProperty("--slider-index", sliderIndex - 1)
        }
    }

    if (handle.classList.contains("right-handle")) {
        if (sliderIndex + 1 >= sets) {
            slider.style.setProperty("--slider-index", 0)
        } else {
            slider.style.setProperty("--slider-index", sliderIndex + 1)
        }
    }
}

function throttle(cb, delay = 1000) {
    let shouldWait = false
    let waitingArgs
    const timeoutFunc = () => {
        if (waitingArgs == null) {
            shouldWait = false
        } else {
            cb(...waitingArgs)
            waitingArgs = null
            setTimeout(timeoutFunc, delay)
        }
    }

    return (...args) => {
        if (shouldWait) {
            waitingArgs = args
            return
        }

        cb(...args)
        shouldWait = true
        setTimeout(timeoutFunc, delay)
    }
}