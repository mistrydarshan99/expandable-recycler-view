package com.thoughtbot.expandablerecyclerview.sample;

import com.thoughtbot.expandablerecyclerview.sample.multicheck.MultiCheckGenre;
import com.thoughtbot.expandablerecyclerview.sample.singlecheck.SingleCheckGenre;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreDataFactory {

  public static List<Genre> makeGenres() {
   /* return Arrays.asList(makeRockGenre(), makeJazzGenre(), makeClassicGenre(), makeSalsaGenre(),
        makeBluegrassGenre());*/
    List<Genre> genreList = new ArrayList<>();
    genreList.add(makeRockGenre());
    genreList.add(makeJazzGenre());
    genreList.add(makeClassicGenre());
    genreList.add(makeSalsaGenre());
    genreList.add(makeBluegrassGenre());
    genreList.add(makeRockGenreAgain());
    return genreList;
  }

  public static List<Genre> makeRefresh() {
    List<Genre> genreList = new ArrayList<>();
    genreList.add(makeRockGenre());
    genreList.add(makeJazzGenre());
    return genreList;
  }

  public static List<MultiCheckGenre> makeMultiCheckGenres() {
    //return Arrays.asList(makeMultiCheckRockGenre(), makeMultiCheckJazzGenre(),
    //    makeMultiCheckClassicGenre(), makeMultiCheckSalsaGenre(), makeMulitCheckBluegrassGenre());

    List<MultiCheckGenre> genreList = new ArrayList<>();
    genreList.add(makeMultiCheckRockGenre());
    genreList.add(makeMultiCheckJazzGenre());
    genreList.add(makeMultiCheckClassicGenre());
    genreList.add(makeMultiCheckSalsaGenre());
    genreList.add(makeMulitCheckBluegrassGenre());
    return genreList;
  }

  public static List<MultiCheckGenre> makeMultiCheckGenres1() {
    return Arrays.asList(makeMultiCheckRockGenre());
  }

  public static List<SingleCheckGenre> makeSingleCheckGenres() {
    return Arrays.asList(makeSingleCheckRockGenre(), makeSingleCheckJazzGenre(),
        makeSingleCheckClassicGenre(), makeSingleCheckSalsaGenre(),
        makeSingleCheckBluegrassGenre());
  }

  public static Genre makeRockGenre() {
    Genre rock = new Genre("Rock", makeRockArtists(), R.drawable.ic_electric_guitar);
    rock.setChildAvaiable(true);
    rock.setParentId(9825);
    return rock;
  }

  public static Genre makeRockGenreAgain() {
    Genre rock = new Genre("Rock Again", makeRockArtists(), R.drawable.ic_electric_guitar);
    rock.setChildAvaiable(true);
    rock.setParentId(9735);
    return rock;
  }

  public static MultiCheckGenre makeMultiCheckRockGenre() {
    return new MultiCheckGenre("Rock", makeRockArtists(), R.drawable.ic_electric_guitar);
  }

  public static SingleCheckGenre makeSingleCheckRockGenre() {
    return new SingleCheckGenre("Rock", makeRockArtists(), R.drawable.ic_electric_guitar);
  }

  public static List<Artist> makeRockArtists() {
    Artist queen = new Artist("Queen", true);
    Artist styx = new Artist("Styx", false);
    Artist reoSpeedwagon = new Artist("REO Speedwagon", false);
    Artist boston = new Artist("Boston", true);

    List<Artist> listArtist = new ArrayList<>();
    /*listArtist.add(queen);
    listArtist.add(styx);
    listArtist.add(reoSpeedwagon);
    listArtist.add(boston);*/

    return listArtist;
  }

  public static Genre makeJazzGenre() {
    return new Genre("Jazz", makeJazzArtists(), R.drawable.ic_saxaphone);
  }

  public static MultiCheckGenre makeMultiCheckJazzGenre() {
    return new MultiCheckGenre("Jazz", makeJazzArtists(), R.drawable.ic_saxaphone);
  }

  public static SingleCheckGenre makeSingleCheckJazzGenre() {
    return new SingleCheckGenre("Jazz", makeJazzArtists(), R.drawable.ic_saxaphone);
  }

  public static List<Artist> makeJazzArtists() {
    Artist milesDavis = new Artist("Miles Davis", true);
    milesDavis.setParentId(111);
    milesDavis.setId(2000);
    Artist milesDavis1 = new Artist("Miles Davis1", true);
    milesDavis1.setParentId(1101);
    milesDavis1.setId(2250);
    Artist ellaFitzgerald = new Artist("Ella Fitzgerald", true);
    ellaFitzgerald.setParentId(111);
    ellaFitzgerald.setId(20001);
    Artist billieHoliday = new Artist("Billie Holiday", false);
    billieHoliday.setParentId(111);
    billieHoliday.setId(20002);

    List<Artist> listArtist = new ArrayList<>();
    listArtist.add(milesDavis);
    listArtist.add(ellaFitzgerald);
    listArtist.add(billieHoliday);
    listArtist.add(milesDavis1);

    return listArtist;
  }

  public static Genre makeClassicGenre() {
    return new Genre("Classic", makeClassicArtists(), R.drawable.ic_violin);
  }

  public static MultiCheckGenre makeMultiCheckClassicGenre() {
    return new MultiCheckGenre("Classic", makeClassicArtists(), R.drawable.ic_violin);
  }

  public static SingleCheckGenre makeSingleCheckClassicGenre() {
    return new SingleCheckGenre("Classic", makeClassicArtists(), R.drawable.ic_violin);
  }

  public static List<Artist> makeClassicArtists() {
    Artist beethoven = new Artist("Ludwig van Beethoven", false);
    Artist bach = new Artist("Johann Sebastian Bach", true);
    Artist brahms = new Artist("Johannes Brahms", false);
    Artist puccini = new Artist("Giacomo Puccini", false);

    List<Artist> listArtist = new ArrayList<>();
    listArtist.add(beethoven);
    listArtist.add(bach);
    listArtist.add(brahms);
    listArtist.add(puccini);

    return listArtist;
  }

  public static Genre makeSalsaGenre() {
    return new Genre("Salsa", makeSalsaArtists(), R.drawable.ic_maracas);
  }

  public static MultiCheckGenre makeMultiCheckSalsaGenre() {
    return new MultiCheckGenre("Salsa", makeSalsaArtists(), R.drawable.ic_maracas);
  }

  public static SingleCheckGenre makeSingleCheckSalsaGenre() {
    return new SingleCheckGenre("Salsa", makeSalsaArtists(), R.drawable.ic_maracas);
  }

  public static List<Artist> makeSalsaArtists() {
    Artist hectorLavoe = new Artist("Hector Lavoe", true);
    Artist celiaCruz = new Artist("Celia Cruz", false);
    Artist willieColon = new Artist("Willie Colon", false);
    Artist marcAnthony = new Artist("Marc Anthony", false);

    List<Artist> listArtist = new ArrayList<>();
    listArtist.add(hectorLavoe);
    listArtist.add(celiaCruz);
    listArtist.add(willieColon);
    listArtist.add(marcAnthony);

    return listArtist;
  }

  public static Genre makeBluegrassGenre() {
    return new Genre("Bluegrass", makeBluegrassArtists(), R.drawable.ic_banjo);
  }

  public static MultiCheckGenre makeMulitCheckBluegrassGenre() {
    return new MultiCheckGenre("Bluegrass", makeBluegrassArtists(), R.drawable.ic_banjo);
  }

  public static SingleCheckGenre makeSingleCheckBluegrassGenre() {
    return new SingleCheckGenre("Bluegrass", makeBluegrassArtists(), R.drawable.ic_banjo);
  }

  public static List<Artist> makeBluegrassArtists() {
    Artist billMonroe = new Artist("Bill Monroe", false);
    Artist earlScruggs = new Artist("Earl Scruggs", false);
    Artist osborneBrothers = new Artist("Osborne Brothers", true);
    Artist johnHartford = new Artist("John Hartford", false);

    List<Artist> listArtist = new ArrayList<>();
    listArtist.add(billMonroe);
    listArtist.add(earlScruggs);
    listArtist.add(osborneBrothers);
    listArtist.add(johnHartford);

    return listArtist;
  }
}

