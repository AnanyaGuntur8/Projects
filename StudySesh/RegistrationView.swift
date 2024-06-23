//
//  RegistrationView.swift
//  studysesh
//
//  Created by Ananya Guntur on 6/20/24.
//

import SwiftUI

struct RegistrationView: View {
    @State private var email = ""
    @State private var fullName = ""
    @State private var password = ""
    @State private var confirmPassword = ""
    @Environment(\.dismiss) var dismiss
    
    var body: some View {
        NavigationStack{
            VStack{
                //image
                
                Text("Sign Up")
                    .font(.largeTitle)
                    .fontWeight(.bold)
                    .padding(.top, 30)
                    .padding(.leading, 20)
                    .frame(maxWidth: .infinity, alignment: .leading)
                VStack(spacing: 24){
                    InputView(text: $email,
                              title: "Email Address",
                              placeholder:"name@example.com")
                    .autocapitalization(.none)
                    
                    InputView(text: $fullName,
                              title: "Full name",
                              placeholder: "Enter Your Full Name")
                    InputView(text: $password,
                              title: "Enter Password",
                              placeholder: "Enter Your Password",
                              isSecureField: true)
                    InputView(text: $confirmPassword,
                              title: "Confirm Password",
                              placeholder: "Enter Your Password",
                              isSecureField: true)
                    
                    
                }
                .padding(.horizontal)
                .padding(.top, 12)
                
                Button{
                    print("Login")
                    
                } label: {
                    HStack{
                        Text("Sign In")
                            .fontWeight(.semibold)
                        Image(systemName: "arrow.right")
                    }
                    .foregroundColor(.white)
                    .frame(width: UIScreen.main.bounds.width - 32, height: 48)
                }
                .background(Color(.systemBlue))
                .cornerRadius(30)
                .padding(.top)
                
                Spacer()
                
                Button{
                    dismiss()
                } label: {
                    HStack{
                        Text("Already Have An Account?")
                        Text("Log in")
                            .fontWeight(.bold)
                    }
                }
            }
        }
    }
}

struct RegistrationView_Previews: PreviewProvider {
    static var previews: some View {
        RegistrationView()
    }
}
