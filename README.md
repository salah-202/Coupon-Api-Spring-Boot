# Coupon Service for E-Commerce

## About

The Coupon Service is an integral part of our e-commerce platform, responsible for managing and applying coupon codes during the checkout process. It also maintains a record of coupon usage in the couponHistory table, allowing us to track and analyze coupon effectiveness.

## Features

- **Coupon Code Management**: Easily create, edit, and delete coupon codes through a user-friendly interface.

- **Discount Rules**: Set up various discount rules such as fixed amount, percentage, or free shipping.

- **Expiration Dates**: Define expiration dates for coupons to create a sense of urgency.

- **Usage Limits**: Control how many times a coupon can be used, either per customer or in total.

- **Coupon History**: Store a record of coupon usage, including the order ID, for tracking and analysis.

- **Integration**: Seamlessly integrate with our e-commerce platform via a RESTful API.

## Project Structure

The project follows a well-organized structure:

- **Controllers**: Handle incoming HTTP requests and manage coupon-related operations.

- **Services**: Implement business logic, including coupon validation and usage tracking.

- **Repositories**: Interface with the database to perform CRUD operations on coupons and couponHistory.

- **StructMap**: Define data structures and models used throughout the project.

## Database Migrations

We use Liquibase for database schema management. To apply database changes, please refer to the Database Migrations guide.

## API Documentation with Swagger

The Coupon Service API is documented using Swagger. Access the API documentation and explore endpoints and request/response examples at Swagger UI.
