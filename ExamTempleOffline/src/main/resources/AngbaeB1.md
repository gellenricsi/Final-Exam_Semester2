Benutzer: guest001@fh-burgenland.at
Kennwort: ni9EKJy#

# Exam - Simulieren eines Audioplayer
Erstelle ein Programm, welches einen Audioplayer samt Output Device simuliert.

Lesezeit: 5 Minuten
Fragezeit: 10 Minuten.
Dauer des Exam insgesamt: 3:15h.


##Ziel
Die Anwendung hat zum Ziel, einen Audioplayer mit Output-Devices zu simulieren.

Hauptbenutzer:in ist die Person, die den Player bedient (dh, Verwaltungsaufgaben und Player-Funktionalität in einer Person)

Die Menüführung ist von Dir, unter Beachtung der Requirements, selbst zu gestalten.

## Requirements
Es gibt ein File, welches mehrere Lieder (songs.json) beinhaltet. Diese Liste wird bei Programmstart einmalig geladen.
Ein Song hat einen Titel, eine TrackID, eine Dauer Sekunden plus das dazugehörige Album und den Interpreten. Alle Parameter sind verpflichtend, unveränderlich und immer in der Datei gegeben!

Lieder aus der Songliste können zu einer Playliste zusammengefügt werden. Es gibt immer nur eine Playlist.

Eine Prüfung, ob der Song bereits in der Song-/Playliste ist, ist nicht notwendig. Ein neues Lied aus der Songliste wird immer am Ende der Playlist eingefügt.

Am Player können mehrere Output-Devices (identifiziert durch einen Namen - geh' davon aus, dass der:die Nutzer:in nur eindeutige Namen vergibt) registriert werden. Sobald ein Lied abgespielt wird, müssen diese Output-Devices informiert werden. Wenn keine Output-Devices registriert sind, soll eine NoDeviceFoundException geworfen werden, die zu einer Aufforderung auf der Console führt, ein Device zu registrieren. (Rückkehr zum Menü!).

Der Player besitzt folgende Möglichkeiten
* Output-Device registrieren
* Output-Device deregistrieren
* Die Songliste anzeigen
* Die Playliste anzeigen
* Ein Lied aus der Songliste in die Playlist hinzufügen
* Playliste abspielen

Die Output-Devices melden an die Konsole, wenn ein Lied abgespielt(empfangen) wird. Gib einen einen sinnvollen Text samt Formatierung aus.

Im Player soll die Möglichkeit gegeben sein, die verfügbaren Lieder so auszugeben, dass diese einfach in die Playliste aufgenommen werden können. (Der Einfachheit halber gib bei jedem Aufruf nur ein Lied an. [S. Bonusaufgabe])

Es soll die Möglichkeit geben, die Playlist abzuspielen. 
Die Playlist soll folgendes beherrschen:
* Nächstes Lied abspielen 
* Zum vorherigen Lied zurück springen
* Playlist erneut starten


Dazu muss ein Menüpunkt "Nächstes Lied abspielen" vorhanden sein - dieser "spielt" das nächste Lied ab (= informiert die Devices). Es kann keine leere Playlist abgespielt werden (Ausgabe einer Meldung auf System.err). Beim letzten Lied der Playlist soll wieder von vorne begonnen werden. Gib einen sinnvollen Text aus, wenn das Lied abgespielt wird.

Diese Playlist soll in einem File abgespeichert werden können, sobald der:die Nutzer:in dies möchte.

### Extra Punkte (max 100 Punkte insgesamt auf das Exam).
* Hinzufügen von mehreren Liedern zur Playlist auf einmal + 2 Punkte
* Pro Unit test, welcher _sinnvoll_ die verschiedenen _Abläufe_ (auch Edge cases) testet +je 2 Punkte
* Laden der gespeicherten Playlist und ersetzen der aktuellen Playlist. +5 Punkte
* Logging. (unter Beachtung der verschiedenen Level!) +5 Punkte
* Gesamtlaufzeit der Playlist ausrechnen und in Minuten und Sekunden (zb 30:15 min) anzeigen. +2 Punkte
* Javadoc (1-2 Sätze pro Methode und Klasse, Parameter-Beschreibung!). bis zu +5 Punkten

## Notes!
* Lauffähiges Programm! DH, keine Abstürze zu Beginn des Programms. Andernfalls negativ.
* Clean Code Rules.
* Design Patterns und wählen eines für diesen Anwendungsfall aus.
* Relative Pfade
* Java Naming Conventions und gute "Lesbarkeit" der einzelnen Teile (Interfaces, Klassen, Methoden, Variablen).
* packages nutzen

Du kannst davon ausgehen, dass nur **richtige Eingaben getätigt werden** (kein String, wo ein Integer gefragt ist etc).



Benutzer: guest001@fh-burgenland.at
Kennwort: ni9EKJy#

# Exam - Simulating an Audio Player
Create a program that simulates an audio player along with output devices.

Reading time: 5 minutes
Question time: 10 minutes
Total exam duration: 3:15h

## Objective
The aim of the application is to simulate an audio player with output devices.

The main user is the person operating the player (i.e., management tasks and player functionality in one person).

You are to design the menu navigation yourself, taking into account the requirements.

## Requirements
There is a file that contains several songs (songs.json). This list is loaded once when the program starts.
A song has a title, a track ID, a duration in seconds, and the associated album and artist. All parameters are mandatory, immutable and always provided in the file!

Songs from the song list can be added to a playlist. There is always only one playlist.

It is not necessary to check whether the song is already in the song/playlist. A new song from the song list is always added to the end of the playlist.

Multiple output devices (identified by a name - assume the user only gives unique names) can be registered on the player. As soon as a song is played, these output devices must be informed. If no output devices are registered, a NoDeviceFoundException should be thrown, leading to a prompt on the console to register a device. (Return to menu!).

The player has the following options:
* Register output device
* Deregister output device
* Display the song list
* Display the playlist
* Add a song from the song list to the playlist
* Play the playlist

The output devices report to the console when a song is played (received). Provide a meaningful text with formatting.

The player should have the ability to display the available songs in a way that they can be easily added to the playlist. (For simplicity, only show one song per call. [See bonus task])

There should be an option to play the playlist. The playlist should support the following functions:

* Play the next song
* Jump back to the previous song
* Restart the playlist

"Play next song" - this "plays" the next song (= informs the devices). An empty playlist cannot be played (output a message on System.err). When the last song in the playlist is reached, it should start again from the beginning. Provide a meaningful message when the song is played.

This playlist should be able to be saved to a file whenever the user wishes. 

### Extra Points (max 100 points in total for the exam)
* Adding multiple songs to the playlist at once +2 points
* For each unit test that _meaningfully_ tests the various _processes_ (including edge cases) +2 points each
* Loading the saved playlist and replacing the current playlist +5 points
* Logging (considering the different levels!) +5 points
* Calculate the total duration of the playlist and display in minutes and seconds (e.g., 30:15 min) +2 points
* Javadoc (1-2 sentences per method and class, parameter description!). Up to +5 points

## Notes!
* Functional program! No crashes at the start of the program. Otherwise negative.
* Clean Code Rules.
* Design patterns and choosing one for this application.
* Relative paths
* Java Naming Conventions and good "readability" of the individual parts (interfaces, classes, methods, variables).
* Use packages