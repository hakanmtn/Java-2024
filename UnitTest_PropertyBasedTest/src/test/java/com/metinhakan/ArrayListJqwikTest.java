package com.metinhakan;



import net.jqwik.api.*;

import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.Assumptions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListJqwikTest {

    @Property(tries = 100)
    public void testAddElement(@ForAll String element){

        ArrayList<String> list = new ArrayList<String>();
        int sizeBefore = list.size();
        list.add(element);
        assertEquals(sizeBefore +1 , list.size());

    }

    @Property
    public void testGetElement(@ForAll String element){
        ArrayList<String> list = new ArrayList<>();
        list.add(element);
        assertEquals(element , list.get(0));
    }

    @Property
    public void testContainsElement(@ForAll String element){
        ArrayList<String> list = new ArrayList<>();
        list.add(element);
        assertTrue(list.contains(element));
    }

    @Property
    public void testRemoveElement(@ForAll @Size(min = 1 ) List<String> elements, @ForAll @IntRange(min = 0, max = 100) int index ){

        Assumptions.assumeTrue(index < elements.size());
        ArrayList<String> list = new ArrayList<>(elements);
        int sizeBefore = list.size();
        list.remove(index);
        assertEquals(sizeBefore - 1 , list.size());


    }

    @Property
    public void testClear(@ForAll List<String> elements){
        ArrayList<String> list = new ArrayList<>(elements);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Property
    public void testAdd(@ForAll String element){}


}
