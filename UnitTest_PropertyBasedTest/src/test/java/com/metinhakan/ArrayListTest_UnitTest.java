package com.metinhakan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest_UnitTest {

    private ArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        assertTrue(list.add("Element1"));
        assertEquals(1, list.size());
        assertEquals("Element1", list.get(0));
    }

    @Test
    void testAddAtIndex(){
        assertTrue(list.add("Element1"));
        assertTrue(list.add("Element2"));

        list.add(1, "Element3");

        assertEquals(3, list.size());
        assertEquals("Element1", list.get(0));
        assertEquals("Element3", list.get(1));
        assertEquals("Element2", list.get(2));

    }

    @Test
    void testRemoveByIndex(){
        list.add("Element1");
        list.add("Element2");

        String removedElement = list.remove(1);

        assertEquals("Element2", removedElement);
        assertEquals(1, list.size());
    }

    @Test
    void testRemoveByObject(){
        list.add("Element1");
        list.add("Element2");

        boolean removedElement = list.remove("Element1");
        assertTrue(removedElement);
        assertEquals(1, list.size());
        assertEquals("Element2", list.get(0));

        boolean notRemovedElement = list.remove("Element4");
        assertFalse(notRemovedElement);

    }

    @Test
    void testContains(){
        list.add("Element1");
        list.add("Element2");

        assertTrue(list.contains("Element1"));
        assertTrue(list.contains("Element2"));
        assertFalse(list.contains("Element4"));
    }

    @Test
    void testClear(){
        list.add("Element1");
        list.add("Element2");
        list.clear();


        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testIndexOf(){
        list.add("Element1");
        list.add("Element2");
        list.add("Element1");
        list.add("Element1");

        assertEquals(0, list.indexOf("Element1"));
        assertEquals(1, list.indexOf("Element2"));
        assertEquals(-1, list.indexOf("Element3"));
    }

    @Test
    void testSubList(){
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        list.add("Element4");

        ArrayList<String> subList = new ArrayList<>(list.subList(1,3));

        assertEquals(2, subList.size());
        assertEquals("Element2", subList.get(0));
        assertEquals("Element3", subList.get(1));

    }

    @Test
    void testSet(){
        list.add("Element1");
        list.add("Element2");

        String replacedElement = list.set(0, "Element3");

        assertEquals("Element1", replacedElement);
        assertEquals("Element3", list.get(0));

    }

    @Test
    void testAddAll(){

        ArrayList<String> otherList = new ArrayList<>();
        otherList.add("Element1");
        otherList.add("Element2");

        assertTrue(list.addAll(otherList));
        assertEquals(2, list.size());
        assertEquals("Element1", list.get(0));
        assertEquals("Element2", list.get(1));


    }


    @Test
    void testClone(){

        ArrayList<String> otherList = new ArrayList<>();
        otherList.add("Element1");
        otherList.add("Element2");

        list = (ArrayList<String>) otherList.clone();

        assertEquals(list, otherList);
        assertFalse(list == otherList);

        assertEquals(2, list.size());
        assertEquals("Element1", list.get(0));
        assertEquals("Element2", list.get(1));

    }

    @Test
    void testGet(){
        list.add("Element1");
        assertEquals("Element1", list.get(0));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    void testIsEmpty(){
        assertTrue(list.isEmpty());
    }

    @Test
    void testSize(){

        assertEquals(0, list.size());

        list.add("Element1");
        assertEquals(1, list.size());

        list.add("Element2");
        assertEquals(2, list.size());

        list.remove("Element1");
        assertEquals(1, list.size());

        list.clear();
        assertEquals(0, list.size());
    }


}
