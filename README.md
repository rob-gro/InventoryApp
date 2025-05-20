# Inventory App

Inventory App is a comprehensive e-commerce system for managing product inventory and shopping carts, enabling businesses to organize their catalog with a hierarchical structure of brands, categories, and products. The application leverages modern web technologies to create an intuitive user interface, providing a complete solution for inventory management with user authentication and role-based access control.

## 🚀 Features

### 📦 Product Management
- **Brand Management**: Create and organize product brands
- **Category Management**: Categorize products within brands
- **Product Administration**: Add, edit, and delete products with detailed specifications
- **Product Details**: Support for dynamic product attributes and specifications

### 🛒 Shopping Cart Features
- **Cart Items**: Add products to user-specific shopping carts
- **Quantity Management**: Adjust product quantities in cart
- **User Association**: Carts linked to specific user accounts

### 👤 User Management
- **User Accounts**: Create and manage user profiles
- **Role-Based Access**: Assign specific roles and permissions to users
- **Authentication**: Secure login and user verification
- **Administrative Functions**: User management interface for administrators

## 🗂 Data Structure

### Hierarchical Catalog
- **Brands** → **Categories** → **Products** → **Product Details**
- Each product belongs to a category
- Each category belongs to a brand
- Each product can have multiple custom details/specifications

### User System
- **Users** with credentials and profile information
- **Roles** that define permissions and access levels
- Many-to-many relationship between users and roles

## 🛠 Technologies

- **Backend**: Java with Spring Boot framework
- **Data Layer**: Spring Data JPA with Hibernate
- **Database**: Relational database with complex entity relationships
- **Frontend**: Thymeleaf templates (inferred from controller return values)
- **Architecture**: Model-View-Controller (MVC)

## 📱 Project Structure

### Main Components

#### Product Catalog
- **Brand Module**:
    - `Brand.java` - Brand entity with categories relationship
    - `BrandController.java` - Controller handling brand operations
    - `BrandRepository.java` - Data access for brands

- **Category Module**:
    - `Category.java` - Category entity with brand relationship
    - `CategoryController.java` - Controller for category operations
    - `CategoryRepository.java` - Data access for categories

- **Product Module**:
    - `Product.java` - Product entity with category relationship and details
    - `ProductDetails.java` - Entity for product specifications
    - `ProductController.java` - Controller handling product operations
    - `ProductRepository.java` - Data access for products

#### User Management
- **User Module**:
    - `User.java` - User entity with roles relationship
    - `Role.java` - Role entity for permissions
    - `UserController.java` - Controller for user operations
    - `RoleRepository.java` - Data access for roles
    - `UserRepository.java` - Data access for users

#### Shopping Cart
- **Cart Module**:
    - `CartItem.java` - Entity representing items in a user's cart

#### Application Core
- `AppController.java` - Main controller for the application home page

## 💻 User Interface

The application contains several main views:
- Home page with application overview
- Brand management pages
- Category management pages
- Product management with detailed forms
- User administration interface
- Shopping cart functionality

## 🚀 Deployment

To run the application:
1. Ensure you have Java installed and a database configured
2. Set up the database with the required tables
3. Adjust the connection settings in `application.properties` if necessary
4. Run the application using Spring Boot

## 🔐 Security & Data Integrity

- **Role-Based Access Control**: Users assigned specific roles and permissions
- **Relational Integrity**: JPA relationships maintain data consistency
- **Custom Validations**: Entity constraints for data quality
- **Secure Authentication**: User password management

---

Inventory App represents a modern approach to e-commerce inventory management, offering a robust, scalable solution built on reliable Spring Boot technology. The system provides businesses with a comprehensive toolkit for managing their product catalog, user base, and shopping functionality through an intuitive, web-based interface.
