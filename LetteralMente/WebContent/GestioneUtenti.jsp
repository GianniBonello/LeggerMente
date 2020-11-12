<jsp:include page="/HeaderStaff.jsp"></jsp:include>

<div class="container-fluid utenti bg-danger ">

	<h1 class="col-9 offset-3 pt-5 text-center ">
		<b>Gestione utenti</b>
	</h1>

	<div
		class="row col-9 offset-6 mt-3 mb-3 centrare>
               
                         
                 <form action=" listalibri.jsp" method="post">
            <div class="filtraLibro pt-5 pl-5">
                <div class="input-group mb-3">
                    <p class="pt-2 pr-3">Filtra per :</p>
                    <select class="custom-select bg-light shadow " id="inputGroupSelect01">
                        <option selected value="nome">Nome</option>
                        <option value="cognome">Cognome</option>
                        <option value="cf">Codice fiscale</option>
                        <option value="username">Username</option>

                    </select>
                </div>
            </div>
            </form>
        </div>


        <div class="row">
            <div class="pt-5 pb-5 col-9 offset-3">
                <table class="table">
                    <thead class="bg-dark text-white">
                        <tr>
                            <th scope="col" class="text-center stonda">#</th>
                            <th scope="col" class="text-center">Username</th>
                            <th scope="col" class="text-center">Utente</th>
                            <th scope="col" class="text-center">Email</th>
                            <th scope="col" class="text-center">Staff</th>
                            <th scope="col" class="text-center stondadue">Comandi</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="chiaro nero">
                            <td class="text-center pt-4">1</td>
                            <td class="text-center pt-4">ZiaMarzy</td>
                            <td class="text-center pt-4">Marzullo</td>
                            <td class="text-center pt-4">ziamargy@hotmail.com</td>
                            <td class="text-center pt-4">

                                <label class="switch">
                                    <input type="checkbox">
                                    <span class="slider round"></span>
                                  </label>

                            </td>
                            <td class="text-center pt-4">
                                <a data-toggle="collapse" data-target="#demo2" role="button" aria-expanded="false"
                                        aria-controls="collapseExample">
                                       
                                        <i class="fas fa-pencil-alt text-white"></i></a>
                                
                                    <i class="fas fa-check-circle verde"></i>
                                <i class="fas fa-times-circle text-danger"></i>
                            </td>
                        <tr>
                            <td colspan="6" class="hiddenRow bgcoll">
                                <div id="demo2" class="collapse">
                                    
                                        

                                            <div class="col-8 offset-2 pt-4">
                                                <form action="Registrazione" method="post">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-12 pt-1">
                                                            <label for="nomeid">Nome </label>
                                                            <input type="text" name="nome"
                                                                class="cazzo form-control pl-4 shadow p-1 mb-1"
                                                                id="nomeid value="u.getNome()"
		required></div>
	<div class="form-group col-md-12 pt-1">
		<label for="cognomeid">Cognome </label> <input type="text"
			name="cognome" class="form-control pl-4 shadow p-1 mb-1 bg-white"
			id="cognomeid" value="u.getCognome()" required>
	</div>
</div>

<div class="form-row">
	<div class="form-group col-xl-6 pt-1">
		<label for="cfid">Codice fiscale </label> <input type="text" name="cf"
			class="form-control pl-4 shadow p-1 mb-1 bg-white" id="cfid"
			value="u.getCf()" required>
	</div>

	<div class="form-group col-xl-6 pt-1">
		<label for="nascitaid">Data di nascita </label> <input type="date"
			name="datadinascita"
			class="form-control pl-4 shadow p-1 mb-1 bg-white" id="nascitaid"
			value="u.getDataDiNascita()" required>
	</div>
</div>

<div class="form-row">
	<div class="form-group col-md-12 pt-1">
		<label for="emailid">Email </label> <input type="email" name="email"
			class="form-control pl-4 shadow p-1 mb-1 bg-white" id="emailid"
			value="u.getEmail()" required>
	</div>
</div>

<div class="form-row">
	<div class="form-group col-xl-5 pt-1">
		<label for="indirizzoid">Indirizzo </label> <input type="text"
			name="indirizzo" class="form-control pl-4 shadow p-1 mb-1 bg-white"
			id="indirizzoid" value="u.getIndirizzo()" required>
	</div>

	<div class="form-group col-xl-5 pt-1">
		<label for="comuneid">Comune </label> <input type="text" name="comune"
			class="form-control pl-4 shadow p-1 mb-1 bg-white" id="comuneid"
			value="u.getComune()" required>
	</div>
	<div class="form-group col-xl-2 pt-1">
		<label for="capid">CAP </label> <input type="text" maxlength="5"
			pattern="([0-9]|[0-9]|[0-9]|[0-9]|[0-9])" name="cap"
			class="form-control pl-4 shadow p-1 mb-1 bg-white" id="capid"
			value="u.getCap()" required>
	</div>
</div>

<div class="form-row">
	<div class="form-group col-xl-6 pt-1">
		<label for="pwid">Username </label> <input type="text" name="password"
			class="form-control pl-4 shadow p-1 mb-1 bg-white" id="pwid"
			value="u.getUsername()" required>
	</div>

	<div class="form-group col-xl-6 pt-1">
		<label for="cpwid">Password </label> <input type="password"
			name="password" class="form-control pl-4 shadow p-1 mb-1 bg-white"
			id="cpwid" value="u.getPassword()" required>
	</div>
</div>




<div class="text-center pt-4">
	<button type="submit"
		class="mt-2 py-2 pl-5 pr-5 mr-5 text-white shadow p-1 mb-5 "
		id="bottone" type="submit">MODIFICA</button>
	<button type="submit"
		class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5" id="bottone"
		type="submit">ANNULLA</button>

</div>
</form>
</div>


</div>
</td>
</tr>
<tr>
<tr class="chiaro">
	<td class="text-center pt-4">2</td>
	<td class="text-center pt-4">Otto_passerotto</td>
	<td class="text-center pt-4">Paolo Brosio</td>
	<td class="text-center pt-4">passerotto@yahoo.com</td>
	<td class="text-center pt-4">2</td>
	<td class="text-center pt-4">
		<p>
			<a data-toggle="collapse" data-target="#demo3" role="button"
				aria-expanded="false" aria-controls="collapseExample"> <i
				class="fas fa-times-circle fa-lg text-danger"></i></a>
		</p>
	</td>
<tr>
	<td colspan="6" class="hiddenRow bgcoll">
		<div id="demo3" class="collapse">
			<form method="post">
				<div class="form-row ">

					<div class="col-8 offset-2 pt-4">
						<form action="Registrazione" method="post">
							<div class="form-row">
								<div class="form-group col-md-12 pt-1">
									<label for="nomeid">Nome </label> <input type="text"
										name="nome" class="cazzo form-control pl-4 shadow p-1 mb-1"
										id="nomeid">
								</div>
								<div class="form-group col-md-12 pt-1">
									<label for="cognomeid">Cognome </label> <input type="text"
										name="cognome"
										class="form-control pl-4 shadow p-1 mb-1 bg-white"
										id="cognomeid" placeholder="">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-xl-6 pt-1">
									<label for="cfid">Codice fiscale </label> <input type="text"
										name="cf" class="form-control pl-4 shadow p-1 mb-1 bg-white"
										id="cfid" placeholder="">
								</div>

								<div class="form-group col-xl-6 pt-1">
									<label for="nascitaid">Data di nascita </label> <input
										type="email" name="datadinascita"
										class="form-control pl-4 shadow p-1 mb-1 bg-white"
										id="nascitaid" placeholder="">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-12 pt-1">
									<label for="emailid">Email </label> <input type="text"
										name="email"
										class="form-control pl-4 shadow p-1 mb-1 bg-white"
										id="emailid" placeholder="">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-xl-5 pt-1">
									<label for="indirizzoid">Indirizzo </label> <input type="text"
										name="indirizzo"
										class="form-control pl-4 shadow p-1 mb-1 bg-white"
										id="indirizzoid" placeholder="">
								</div>

								<div class="form-group col-xl-5 pt-1">
									<label for="comuneid">Comune </label> <input type="email"
										name="comune"
										class="form-control pl-4 shadow p-1 mb-1 bg-white"
										id="comuneid" placeholder="">
								</div>
								<div class="form-group col-xl-2 pt-1">
									<label for="capid">CAP </label> <input type="email" name="cap"
										class="form-control pl-4 shadow p-1 mb-1 bg-white" id="capid"
										placeholder="">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-xl-6 pt-1">
									<label for="pwid">Username </label> <input type="text"
										name="password"
										class="form-control pl-4 shadow p-1 mb-1 bg-white" id="pwid"
										placeholder="">
								</div>

								<div class="form-group col-xl-6 pt-1">
									<label for="cpwid">Password </label> <input type="email"
										name="confpassword"
										class="form-control pl-4 shadow p-1 mb-1 bg-white" id="cpwid"
										placeholder="">
								</div>
							</div>

						</form>


						<div class="text-center pt-4">
							<button type="submit"
								class="mt-2 py-2 pl-5 pr-5 mr-5 text-white shadow p-1 mb-5 "
								id="bottone" type="submit">MODIFICA</button>
							<button type="submit"
								class="mt-2 py-2 pl-5 pr-5 text-white shadow p-1 mb-5"
								id="bottone" type="submit">ANNULLA</button>

						</div>

					</div>
				</div>
			</form>
		</div>
	</td>
</tr>

<tr>
	</tbody>
	</table>
	</div>
	</div>

	</div>


<jsp:include page="/footerStaff.jsp"></jsp:include> 