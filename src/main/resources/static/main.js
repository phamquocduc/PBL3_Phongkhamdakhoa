const NAV_INDEX_STORAGE_KEY = 'INDEX'


const storage =  {
    get() {
        return JSON.parse(localStorage.getItem(NAV_INDEX_STORAGE_KEY));
    },
    set(index) {
        localStorage.setItem(NAV_INDEX_STORAGE_KEY, JSON.stringify(index));
    },
    delete() {
        localStorage.clear();
    }
};

var navLink = document.querySelectorAll('.link')

navLink[0].classList.value = 'link active';

for(let i=0; i < navLink.length; i++) {
    if(navLink[i].classList.value === 'link active' && storage.get()){
        navLink[i].classList.remove('active');
        navLink[storage.get()].classList.value = 'link active' 
        break;
    }
}

const $ = document.querySelector('.link.active');
const lines = document.querySelector('.nav-link .line');

lines.style.left = $.offsetLeft + 'px';
lines.style.width = $.offsetWidth + 'px';
lines.style.top = $.offsetTop + 42 + 'px';
lines.style.display = 'block';

window.addEventListener('resize', function(event) {
    const $$ = document.querySelector('.link.active');
    lines.style.left = $$.offsetLeft + 'px';
    lines.style.width = $$.offsetWidth + 'px';
});

navLink.forEach((link, index) =>{

    link.onclick = () =>{
        if (index == 0) {
            lines.style.display = 'none';
        }
        for (var i = 0; i < navLink.length; i++) {
            if (navLink[i].classList.value == 'link active') {
                navLink[i].classList.remove('active');
            }
        }
        lines.style.left = navLink[index].offsetLeft + 'px';
        lines.style.width = navLink[index].offsetWidth + 'px';
        
        link.classList.add('active');
        storage.set(index)
    }
})