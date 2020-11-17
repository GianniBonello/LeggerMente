let libri = [ ] ;
$(document).ready(function ( ) {
	$('#aut-cres').on('click', function(){
		libri=[ ];
		let libriNonOrdinati = $('.libro');
		for(let libro of libriNonOrdinati){
			libri.push({  //crei l'oggetto e gli assegni i suoi attributi'
				isbn: 					$(libro).find('.isbn').text(),
				autore: 				$(libro).find('.autore').text(),
				editore: 				$(libro).find('.editore').text(),
				prezzo: 				$(libro).find('.prezzo').text(),
				genere: 				$(libro).find('.genere').text(),
				trama: 					$(libro).find('.trama').text(),
				isUsato: 				$(libro).find('.isUsato').text(),
				quantita: 				$(libro).find('.quantita').text(),
				titolo: 					$(libro).find('.titolo').text(),
				idLibro: 				$(libro).find('.idLibro').attr('href'),
				immaginepath: 	$(libro).find('.immaginepath').attr('src')			
			})
		}
		
		console.log(libri); 
		libri.sort(function(a,b){
			return a.autore.localeCompare(b.autore)
		});
		console.log(libri); 
		
		let i = 0;
		for (let libro of libriNonOrdinati){
			$(libro).find('.isbn').text(libri[i].isbn)
			$(libro).find('.autore').text(libri[i].autore)
			$(libro).find('.editore').text(libri[i].editore)
			$(libro).find('.prezzo').text(libri[i].prezzo)
			$(libro).find('.genere').text(libri[i].genere)
			$(libro).find('.trama').text(libri[i].trama)
			$(libro).find('.isUsato').text(libri[i].isUsato)
			$(libro).find('.quantita').text(libri[i].quantita)
			$(libro).find('.titolo').text(libri[i].titolo)
			$(libro).find('.idLibro').attr('href',libri[i].idLibro)
			$(libro).find('.immaginepath').attr('src',libri[i].immaginepath)
			i++;
		}
		
	})
	
	$('#aut-decr').on('click', function(){
		libri=[ ];
		let libriNonOrdinati = $('.libro');
		for(let libro of libriNonOrdinati){
			libri.push({  //crei l'oggetto e gli assegni i suoi attributi'
				isbn: 					$(libro).find('.isbn').text(),
				autore: 				$(libro).find('.autore').text(),
				editore: 				$(libro).find('.editore').text(),
				prezzo: 				$(libro).find('.prezzo').text(),
				genere: 				$(libro).find('.genere').text(),
				trama: 					$(libro).find('.trama').text(),
				isUsato: 				$(libro).find('.isUsato').text(),
				quantita: 				$(libro).find('.quantita').text(),
				titolo: 					$(libro).find('.titolo').text(),
				idLibro: 				$(libro).find('.idLibro').attr('href'),
				immaginepath: 	$(libro).find('.immaginepath').attr('src')			
			})
		}
		
		console.log(libri); 
		libri.sort(function(a,b){
			return a.autore.localeCompare(b.autore)
		});
		console.log(libri); 
		libri.reverse();
		
		let i = 0;
		for (let libro of libriNonOrdinati){
			$(libro).find('.isbn').text(libri[i].isbn)
			$(libro).find('.autore').text(libri[i].autore)
			$(libro).find('.editore').text(libri[i].editore)
			$(libro).find('.prezzo').text(libri[i].prezzo)
			$(libro).find('.genere').text(libri[i].genere)
			$(libro).find('.trama').text(libri[i].trama)
			$(libro).find('.isUsato').text(libri[i].isUsato)
			$(libro).find('.quantita').text(libri[i].quantita)
			$(libro).find('.titolo').text(libri[i].titolo)
			$(libro).find('.idLibro').attr('href',libri[i].idLibro)
			$(libro).find('.immaginepath').attr('src',libri[i].immaginepath)
			i++;
		}
		
	})
	
	$('#prezzo-cres').on('click', function(){
		libri=[ ];
		let libriNonOrdinati = $('.libro');
		for(let libro of libriNonOrdinati){
			libri.push({  //crei l'oggetto e gli assegni i suoi attributi'
				isbn: 					$(libro).find('.isbn').text(),
				autore: 				$(libro).find('.autore').text(),
				editore: 				$(libro).find('.editore').text(),
				prezzo: 				$(libro).find('.prezzo').text(),
				genere: 				$(libro).find('.genere').text(),
				trama: 					$(libro).find('.trama').text(),
				isUsato: 				$(libro).find('.isUsato').text(),
				quantita: 				$(libro).find('.quantita').text(),
				titolo: 					$(libro).find('.titolo').text(),
				idLibro: 				$(libro).find('.idLibro').attr('href'),
				immaginepath: 	$(libro).find('.immaginepath').attr('src')			
			})
		}
		
		console.log(libri); 
		libri.sort(function(a,b){
			return a.prezzo - b.prezzo
		});
		console.log(libri); 
		
		let i = 0;
		for (let libro of libriNonOrdinati){
			$(libro).find('.isbn').text(libri[i].isbn)
			$(libro).find('.autore').text(libri[i].autore)
			$(libro).find('.editore').text(libri[i].editore)
			$(libro).find('.prezzo').text(libri[i].prezzo)
			$(libro).find('.genere').text(libri[i].genere)
			$(libro).find('.trama').text(libri[i].trama)
			$(libro).find('.isUsato').text(libri[i].isUsato)
			$(libro).find('.quantita').text(libri[i].quantita)
			$(libro).find('.titolo').text(libri[i].titolo)
			$(libro).find('.idLibro').attr('href',libri[i].idLibro)
			$(libro).find('.immaginepath').attr('src',libri[i].immaginepath)
			i++;
		}
		
	})
	
	$('#prezzo-decr').on('click', function(){
		libri=[ ];
		let libriNonOrdinati = $('.libro');
		for(let libro of libriNonOrdinati){
			libri.push({  //crei l'oggetto e gli assegni i suoi attributi'
				isbn: 					$(libro).find('.isbn').text(),
				autore: 				$(libro).find('.autore').text(),
				editore: 				$(libro).find('.editore').text(),
				prezzo: 				$(libro).find('.prezzo').text(),
				genere: 				$(libro).find('.genere').text(),
				trama: 					$(libro).find('.trama').text(),
				isUsato: 				$(libro).find('.isUsato').text(),
				quantita: 				$(libro).find('.quantita').text(),
				titolo: 					$(libro).find('.titolo').text(),
				idLibro: 				$(libro).find('.idLibro').attr('href'),
				immaginepath: 	$(libro).find('.immaginepath').attr('src')			
			})
		}
		
		console.log(libri); 
		libri.sort(function(a,b){
			return a.prezzo - b.prezzo
		});
		console.log(libri); 
		libri.reverse();
		
		let i = 0;
		for (let libro of libriNonOrdinati){
			$(libro).find('.isbn').text(libri[i].isbn)
			$(libro).find('.autore').text(libri[i].autore)
			$(libro).find('.editore').text(libri[i].editore)
			$(libro).find('.prezzo').text(libri[i].prezzo)
			$(libro).find('.genere').text(libri[i].genere)
			$(libro).find('.trama').text(libri[i].trama)
			$(libro).find('.isUsato').text(libri[i].isUsato)
			$(libro).find('.quantita').text(libri[i].quantita)
			$(libro).find('.titolo').text(libri[i].titolo)
			$(libro).find('.idLibro').attr('href',libri[i].idLibro)
			$(libro).find('.immaginepath').attr('src',libri[i].immaginepath)
			i++;
		}
		
	})
	
	$('#ultimiarrivi').on('click', function(){
		libri=[ ];
		let libriNonOrdinati = $('.libro');
		for(let libro of libriNonOrdinati){
			libri.push({  //crei l'oggetto e gli assegni i suoi attributi'
				isbn: 					$(libro).find('.isbn').text(),
				autore: 				$(libro).find('.autore').text(),
				editore: 				$(libro).find('.editore').text(),
				prezzo: 				$(libro).find('.prezzo').text(),
				genere: 				$(libro).find('.genere').text(),
				trama: 					$(libro).find('.trama').text(),
				isUsato: 				$(libro).find('.isUsato').text(),
				quantita: 				$(libro).find('.quantita').text(),
				titolo: 					$(libro).find('.titolo').text(),
				idLibro: 				$(libro).find('.idLibro').attr('href'),
				immaginepath: 	$(libro).find('.immaginepath').attr('src')			
			})
		}
		

		libri.sort(function(a,b){
			return a.idLibro - b.idLibro
		});
	
		libri.reverse();
		
		let i = 0;
		for (let libro of libriNonOrdinati){
			$(libro).find('.isbn').text(libri[i].isbn)
			$(libro).find('.autore').text(libri[i].autore)
			$(libro).find('.editore').text(libri[i].editore)
			$(libro).find('.prezzo').text(libri[i].prezzo)
			$(libro).find('.genere').text(libri[i].genere)
			$(libro).find('.trama').text(libri[i].trama)
			$(libro).find('.isUsato').text(libri[i].isUsato)
			$(libro).find('.quantita').text(libri[i].quantita)
			$(libro).find('.titolo').text(libri[i].titolo)
			$(libro).find('.idLibro').attr('href',libri[i].idLibro)
			$(libro).find('.immaginepath').attr('src',libri[i].immaginepath)
			i++;
		}
		
	})
	
		$('#nol').on('click', function(){
		libri=[ ];
		let libriNonOrdinati = $('.libro');
		for(let libro of libriNonOrdinati){
			libri.push({  //crei l'oggetto e gli assegni i suoi attributi'
				isbn: 					$(libro).find('.isbn').text(),
				autore: 				$(libro).find('.autore').text(),
				editore: 				$(libro).find('.editore').text(),
				prezzo: 				$(libro).find('.prezzo').text(),
				genere: 				$(libro).find('.genere').text(),
				trama: 					$(libro).find('.trama').text(),
				isUsato: 				$(libro).find('.isUsato').text(),
				quantita: 				$(libro).find('.quantita').text(),
				titolo: 					$(libro).find('.titolo').text(),
				idLibro: 				$(libro).find('.idLibro').attr('href'),
				immaginepath: 	$(libro).find('.immaginepath').attr('src')			
			})
		}
		
		
		
		libri.sort(function(a,b){
			return a.isUsato.localeCompare(b.isUsato)
		});
		
		libri.reverse();
		
		/*
		console.log(libri)
		function filtra(a) {
			if(a.isUsato=='true'){
				return true;
			}
			return false;
		}
		
		console.log(libri)
		libri.filter(filtra);
		console.log(libri[1].isUsato==false)
		console.log(libri[1].isUsato=='false')
		console.log(libri[1].isUsato=='true')
		
		console.log(libri[1].isUsato)
		console.log(typeof libri[1].isUsato)
*/
		
		
		let i = 0;
		for (let libro of libriNonOrdinati){
			$(libro).find('.isbn').text(libri[i].isbn)
			$(libro).find('.autore').text(libri[i].autore)
			$(libro).find('.editore').text(libri[i].editore)
			$(libro).find('.prezzo').text(libri[i].prezzo)
			$(libro).find('.genere').text(libri[i].genere)
			$(libro).find('.trama').text(libri[i].trama)
			$(libro).find('.isUsato').text(libri[i].isUsato)
			$(libro).find('.quantita').text(libri[i].quantita)
			$(libro).find('.titolo').text(libri[i].titolo)
			$(libro).find('.idLibro').attr('href',libri[i].idLibro)
			$(libro).find('.immaginepath').attr('src',libri[i].immaginepath)
			i++;
		}
		
	})
	
	$('#acq').on('click', function(){
		libri=[ ];
		let libriNonOrdinati = $('.libro');
		for(let libro of libriNonOrdinati){
			libri.push({  //crei l'oggetto e gli assegni i suoi attributi'
				isbn: 					$(libro).find('.isbn').text(),
				autore: 				$(libro).find('.autore').text(),
				editore: 				$(libro).find('.editore').text(),
				prezzo: 				$(libro).find('.prezzo').text(),
				genere: 				$(libro).find('.genere').text(),
				trama: 					$(libro).find('.trama').text(),
				isUsato: 				$(libro).find('.isUsato').text(),
				quantita: 				$(libro).find('.quantita').text(),
				titolo: 					$(libro).find('.titolo').text(),
				idLibro: 				$(libro).find('.idLibro').attr('href'),
				immaginepath: 	$(libro).find('.immaginepath').attr('src')			
			})
		}
		
		
		
		libri.sort(function(a,b){
			return a.isUsato.localeCompare(b.isUsato)
		});
		
		
		
		let i = 0;
		for (let libro of libriNonOrdinati){
			$(libro).find('.isbn').text(libri[i].isbn)
			$(libro).find('.autore').text(libri[i].autore)
			$(libro).find('.editore').text(libri[i].editore)
			$(libro).find('.prezzo').text(libri[i].prezzo)
			$(libro).find('.genere').text(libri[i].genere)
			$(libro).find('.trama').text(libri[i].trama)
			$(libro).find('.isUsato').text(libri[i].isUsato)
			$(libro).find('.quantita').text(libri[i].quantita)
			$(libro).find('.titolo').text(libri[i].titolo)
			$(libro).find('.idLibro').attr('href',libri[i].idLibro)
			$(libro).find('.immaginepath').attr('src',libri[i].immaginepath)
			i++;
		}
		
	})
	
	$('#tutti').on('click', function(){
		libri=[ ];
		let libriNonOrdinati = $('.libro');
		for(let libro of libriNonOrdinati){
			libri.push({  //crei l'oggetto e gli assegni i suoi attributi'
				isbn: 					$(libro).find('.isbn').text(),
				autore: 				$(libro).find('.autore').text(),
				editore: 				$(libro).find('.editore').text(),
				prezzo: 				$(libro).find('.prezzo').text(),
				genere: 				$(libro).find('.genere').text(),
				trama: 					$(libro).find('.trama').text(),
				isUsato: 				$(libro).find('.isUsato').text(),
				quantita: 				$(libro).find('.quantita').text(),
				titolo: 					$(libro).find('.titolo').text(),
				idLibro: 				$(libro).find('.idLibro').attr('href'),
				immaginepath: 	$(libro).find('.immaginepath').attr('src')			
			})
		}
		
		
		
		libri.sort(function(a,b){
			return a.idLibro - b.idLibro
		});
	
		libri.reverse();

		
		let i = 0;
		for (let libro of libriNonOrdinati){
			$(libro).find('.isbn').text(libri[i].isbn)
			$(libro).find('.autore').text(libri[i].autore)
			$(libro).find('.editore').text(libri[i].editore)
			$(libro).find('.prezzo').text(libri[i].prezzo)
			$(libro).find('.genere').text(libri[i].genere)
			$(libro).find('.trama').text(libri[i].trama)
			$(libro).find('.isUsato').text(libri[i].isUsato)
			$(libro).find('.quantita').text(libri[i].quantita)
			$(libro).find('.titolo').text(libri[i].titolo)
			$(libro).find('.idLibro').attr('href',libri[i].idLibro)
			$(libro).find('.immaginepath').attr('src',libri[i].immaginepath)
			i++;
		}
		
	})
	
})
