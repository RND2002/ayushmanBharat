package com.codesite.ayushmanProject.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
@Service
public class IdGenerationImpl implements IdGenerationService {

    private static long nextId = 100;
    //private final AtomicLong nextId = new AtomicLong(1);
@Override
public synchronized Long generateUniqueId() {
    //return nextId.getAndIncrement();
    return nextId++;
}
}
