package model;

/**
 * Represents a library member who can borrow books.
 */
public class Member {

    private String memberId;
    private String name;
    private String email;

    /**
     * Creates a new Member object.
     *
     * @param memberId unique ID of the member
     * @param name name of the member
     */
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.email = null; // no email provided
    }

    /**
     * Returns the member ID.
     *
     * @return member ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * Returns the member name.
     *
     * @return member name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the member email (if available).
     *
     * @return email or null
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns a readable representation of the member.
     *
     * @return formatted member information
     */
    @Override
    public String toString() {
        return "Member ID: " + memberId +
                ", Name: " + name +
                ", Email: " + email;
    }
}