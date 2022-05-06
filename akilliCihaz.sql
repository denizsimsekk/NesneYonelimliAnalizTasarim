--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: kayitnosifre(character varying, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.kayitnosifre(inputkullaniciadi character varying, inputsifre character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
begin
	if (SELECT EXISTS(SELECT 1 FROM kullanicilar WHERE "kullanicilar"."kullaniciAdi" = inputkullaniciadi and kullanicilar.sifre=inputsifre) )then
	return 1;
	else
	return 0;
	end if;
end;
$$;


ALTER FUNCTION public.kayitnosifre(inputkullaniciadi character varying, inputsifre character varying) OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: kullanicilar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.kullanicilar (
    "kullaniciAdi" character varying(40) NOT NULL,
    sifre character varying(40) NOT NULL
);


ALTER TABLE public.kullanicilar OWNER TO postgres;

--
-- Data for Name: kullanicilar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.kullanicilar ("kullaniciAdi", sifre) FROM stdin;
deniz	123
yeniKullanici	kullanici345
deneme	deneme2
\.


--
-- Name: kullanicilar kullaniciAdiPK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanicilar
    ADD CONSTRAINT "kullaniciAdiPK" PRIMARY KEY ("kullaniciAdi");


--
-- PostgreSQL database dump complete
--

