package com.hcl.library.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Member {
    private static int idCounter = 1;

    private int id;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems;

    public Member(String name) {
        this(name, null);
    }

    public Member(String name, String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be blank");
        }
        if (email != null && !email.contains("@")) {
            throw new IllegalArgumentException("Email must contain '@'");
        }

        this.id = idCounter++;
        this.name = name.trim();
        this.email = email != null ? email.trim() : "N/A";
        this.borrowedItems = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public List<LibraryItem> getBorrowedItems() {
        return Collections.unmodifiableList(this.borrowedItems);
    }

    public void addBorrowedItem(LibraryItem item) {
        if (item != null) {
            this.borrowedItems.add(item);
        }
    }

    public boolean removeBorrowedItem(LibraryItem item) {
        return this.borrowedItems.remove(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return this.id == member.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "Member #" + this.id + ": " + this.name + " (" + this.email + ")";
    }
}
