

var clickedX = false, clickedY = false, clickX, clickY, px, px1;
$(document).on({
    'mousemove': function (e) {
        clickedX && updateScrollPosX(e);
    },
    'mousedown': function (e) {
        clickedX = true;
        clickX = e.pageX;
    },
    'mouseup': function () {
        clickedX = false;
        $('html').css('cursor', 'auto');
    }
});

var updateScrollPosX = function (e) {

    $('html').css('cursor', 'pointer');
    $(window).scrollLeft($(window).scrollLeft() + (clickX - e.pageX));
    px1 = ($(window).scrollLeft() + (clickY - e.pageY)) / 10
    px1 += px1
    $('div').css('transform', 'translate(' + px1 + 'px,' + px + 'px)')
}

$(document).on({
    'mousemove': function (e) {
        clickedX && updateScrollPosY(e);
    },
    'mousedown': function (e) {
        clickedY = true;
        clickY = e.pageY;
    },
    'mouseup': function () {
        clickedY = false;
        $('html').css('cursor', 'auto');
    }
});

var updateScrollPosY = function (e) {

    $('html').css('cursor', 'pointer');
    $(window).scrollTop($(window).scrollTop() + (clickY - e.pageY));
    px = ($(window).scrollTop() + (clickY - e.pageY)) / 10
    px += px
    $('div').css('transform', 'translate(-' + px1 + 'px,-' + px + 'px)')
}

const zoomElement = document.querySelector(".container-ok");
let zoom = 1;
const ZOOM_SPEED = 0.1;

document.addEventListener("wheel", function (e) {

    if (e.deltaY < 0) {
        zoom += ZOOM_SPEED
        if (zoom > 1.5) {
            zoom = 1.5
            zoomElement.style.transform = `scale(${zoom})`;
        } else {
            zoomElement.style.transform = `scale(${zoom})`;
        }

    } else {

        zoom -= ZOOM_SPEED
        if (zoom < 0.7) {
            zoom = 0.7
            zoomElement.style.transform = `scale(${zoom})`;
        }
        else {
            zoomElement.style.transform = `scale(${zoom})`;
        }

    }

})


function myFunction() {
    $('div.layout-item').attr('id', 'image')
        ($('div.layout-item')).hide()
    setTimeout(() => {
        ($('div.layout-item')).show()
    }, 10);
}







