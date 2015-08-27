jQuery(function($) {

	$(function(){
		$('#main-slider.carousel').carousel({
			interval: 10000,
			pause: false
		});
	});

	//Ajax contact
	var form = $('.contact-form');
	form.submit(function () {
		$this = $(this);
		$.post($(this).attr('action'), function(data) {
			$this.prev().text(data.message).fadeIn().delay(3000).fadeOut();
		},'json');
		return false;
	});


        /*
         * smooth scroll versi lama
	$('a[href*=#];not(href=#)').click(function(event) {
		event.preventDefault();
		var target = $(this).find('>a').prop('hash');
                
		$('html, body').animate({
			scrollTop: $(target).offset().top
		}, 500);
	}); */
    
    /*
     * smooth scrol 
     * Ari Prasetiyo
     * 5/20/2015
     * Versi baru
     */
        
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
              var target = $(this.hash);
              target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
              if (target.length) {
                $('html,body').animate({
                  scrollTop: target.offset().top
                }, 500);
                return false;
              }
            }
          });

	//scrollspy
	$('[data-spy="scroll"]').each(function () {
		var $spy = $(this).scrollspy('refresh')
	})

	//PrettyPhoto
	$("a.preview").prettyPhoto({
		social_tools: false
	});

	//Isotope
	$(window).load(function(){
		$portfolio = $('.portfolio-items');
		$portfolio.isotope({
			itemSelector : 'li',
			layoutMode : 'fitRows'
		});
		$portfolio_selectors = $('.portfolio-filter >li>a');
		$portfolio_selectors.on('click', function(){
			$portfolio_selectors.removeClass('active');
			$(this).addClass('active');
			var selector = $(this).attr('data-filter');
			$portfolio.isotope({ filter: selector });
			return false;
		});
	});
});