# Java-Hair-Salon-DB Application by Archana Bongale

Date August 28th, 2015

Description

This app allows the user to create stylists in a hair salon. The user can also add clients to a specific stylist.
Stylists can be edited and deleted. Clients can be added and deleted.


CREATE DATABASE hair_salon;

\c hair_salon;

CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);

CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylist_id int);

CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;


Setup Instructions

Clone this git repository Run with Gradle and open localhost:4567 in browser.
Technologies Used Java HTML5 CSS Spark ver 2.1 jUnit ver 4.+ Bootstrap ver 3.2.0 Fluentlenium ver 0.10.3 Velocity ver 1.7
