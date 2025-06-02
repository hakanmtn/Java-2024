package com.metinhakan;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assume;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(JUnitQuickcheck.class)
public class ArrayListQuickCheckTest {

    @Property(trials = 100)
    public void testAddElement(String element){
        ArrayList<String> list = new ArrayList<>();
        int sizeBefore = list.size();
        list.add(element);
        assertEquals(sizeBefore + 1, list.size());
    }

    @Property
    public void testGetElement(String element){
        ArrayList<String> list = new ArrayList<>();
        list.add(element);
        assertEquals(element, list.get(0));
    }

    @Property
    public void testContainsElement(String element){
        ArrayList<String> list = new ArrayList<>();
        list.add(element);
        assertTrue(list.contains(element));

    }

    @Property
    public void testRemoveElement(List<String> elements, int index){
        Assume.assumeFalse(elements.isEmpty());
        Assume.assumeTrue(index >= 0 && index < elements.size());

        ArrayList<String> list = new ArrayList<>(elements);
        int sizeBefore = list.size();
        list.remove(index);
        assertEquals(sizeBefore -1 , list.size());

    }

    @Property
    public void testRemoveElementv2(@Size(min = 1, max = 100) List<String> elements, @InRange(min = "0") int index) {

        Assume.assumeFalse(elements.isEmpty());

        index = Math.min(index, elements.size() - 1);

        ArrayList<String> list = new ArrayList<>(elements);
        int sizeBefore = list.size();

        list.remove(index);

        assertEquals(sizeBefore - 1, list.size());
    }

    @Property
    public void testClear(List<String> elements){
        ArrayList<String> list = new ArrayList<>(elements);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }


}
