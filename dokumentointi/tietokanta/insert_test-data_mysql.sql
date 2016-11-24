INSERT INTO authority (id, role)
VALUES (2, 'ROLE_ADMIN');

INSERT INTO authority (id, role)
VALUES (1, 'ROLE_KAYTTAJA');

INSERT INTO Kayttajat(kayttajatunnus, email, etunimi, sukunimi,salasana,enabled)
VALUES('testaaja', 'testaaja@testi.fi', 'Tero', 'Testaaja', '50febc1bb4166aeb020a48dcbde9ac834a069c2c441ec9a07ab83c8c50ebe555428efd575145b228', 1);

INSERT INTO Kayttaja_authority (Kayttaja_id, authority_id)
VALUES (1,1);